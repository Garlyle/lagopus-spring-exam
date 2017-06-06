package com.greenfox.exam.spring.controller;

import com.greenfox.exam.spring.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringController {
  @Autowired
  QuestionRepository questionRepository;

}
