package com.greenfox.exam.spring.controller;

import com.greenfox.exam.spring.model.Question;
import com.greenfox.exam.spring.model.QuestionsResponse;
import com.greenfox.exam.spring.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringController {
  @Autowired
  QuestionRepository questionRepository;

  @GetMapping("/questions")
  public QuestionsResponse getQuestions() {
    QuestionsResponse questionsResponse = new QuestionsResponse();

    int i = 1;
    while (i <= 5) {
      long randomId = (long)(Math.random() * questionRepository.count()) + 1;
      String question = questionRepository.findOne(randomId).getQuestion();
      if (!questionsResponse.contains(question)) {
        questionsResponse.add(new Question(i, question));
        i++;
      }
    }

    return questionsResponse;
  }
}
