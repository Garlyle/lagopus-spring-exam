package com.greenfox.exam.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;
  String question;

  public Question() {
  }

  public Question(long id, String question) {
    this.id = id;
    this.question = question;
  }

  public long getId() {
    return id;
  }

  public String getQuestion() {
    return question;
  }
}
