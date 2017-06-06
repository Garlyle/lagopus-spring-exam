package com.greenfox.exam.spring.controller;

import com.greenfox.exam.spring.model.Project;
import com.greenfox.exam.spring.model.ProjectResponse;
import com.greenfox.exam.spring.model.Question;
import com.greenfox.exam.spring.model.QuestionsResponse;
import com.greenfox.exam.spring.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@RestController
public class SpringController {
  final static String className = "eagles";
  @Autowired
  QuestionRepository questionRepository;

  @GetMapping("/questions")
  public QuestionsResponse getQuestions() {
    QuestionsResponse questionsResponse = new QuestionsResponse();

    int i = 1;
    while (i <= 5) {
      long randomId = (long)(Math.random() * questionRepository.count()) + 1;
      if (!questionsResponse.contains(randomId)) {
        Question repoLookup = questionRepository.findOne(randomId);
        Question question = new Question(randomId);
        question.setQuestion(repoLookup.getQuestion());
        questionsResponse.add(question);
        i++;
      }
    }

    return questionsResponse;
  }

  @PostMapping("/answers")
  public List<Project> checkAnswers(@RequestBody QuestionsResponse answersBody) {
    List<Project> projectList = new ArrayList<>();

    int count = 0;

    List<Question> answers = answersBody.getQuestions();
    for (Question answer : answers) {
      Question goodAnswer = questionRepository.findOne(answer.getId());
      if (answer.getAnswer().equals(goodAnswer.getAnswer())) {
        count++;
      }
    }

    if (count == answers.size()) {
      RestTemplate template = new RestTemplate();
      ProjectResponse response;
      response = template.getForObject("https://springexamserver.herokuapp.com/projects/" + className,
          ProjectResponse.class);
      projectList = response.getProjectList();

      for (Project q : projectList) {
        try {
          q.setNameOfProject(decode(q.getNameOfProject()));
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }

    return projectList;
  }

  public static String decode(String value) throws Exception {
    byte[] decodedValue = Base64.getDecoder().decode(value);  // Basic Base64 decoding
    return new String(decodedValue, StandardCharsets.UTF_8);
  }
}
