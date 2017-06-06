package com.greenfox.exam.spring.repository;

import com.greenfox.exam.spring.model.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
}
