package com.greenfox.exam.spring.model;

import java.util.List;

public class ProjectResponse {
  List<Project> projectList;

  public ProjectResponse(List<Project> projectList) {
    this.projectList = projectList;
  }

  public ProjectResponse() {
  }

  public List<Project> getProjectList() {
    return projectList;
  }
}
