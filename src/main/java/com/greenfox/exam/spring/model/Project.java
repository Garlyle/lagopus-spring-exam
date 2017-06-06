package com.greenfox.exam.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;
  String nameOfProject;

  public Project() {
  }

  public Project(String nameOfProject) {
    this.nameOfProject = nameOfProject;
  }

  public long getId() {
    return id;
  }

  public String getNameOfProject() {
    return nameOfProject;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setNameOfProject(String nameOfProject) {
    this.nameOfProject = nameOfProject;
  }
}
