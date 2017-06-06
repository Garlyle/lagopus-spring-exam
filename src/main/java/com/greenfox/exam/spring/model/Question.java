package com.greenfox.exam.spring.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Question {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;
  String question;
  String answer;

  public Question() {
  }

  public Question(long id) {
    this.id = id;
  }

  public Question(String question, String answer) {
    this.question = question;
    this.answer = answer;
  }

  public long getId() {
    return id;
  }

  public String getQuestion() {
    return question;
  }

  public String getAnswer() {
    return answer;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }
}
