package com.greenfox.exam.spring.model;

import java.util.ArrayList;
import java.util.List;

public class QuestionsResponse {
  long id;
  List<Question> questions;

  public boolean contains(long id) {
    for (Question q : questions) {
      if (q.id == id) {
        return true;
      }
    }
    return false;
  }

  public QuestionsResponse() {
    id = 1;
    questions = new ArrayList<>();
  }

  public void add(Question question) {
    questions.add(question);
  }

  public long getId() {
    return id;
  }

  public List<Question> getQuestions() {
    return questions;
  }
}
