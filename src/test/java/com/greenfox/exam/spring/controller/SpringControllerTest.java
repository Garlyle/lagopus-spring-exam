package com.greenfox.exam.spring.controller;

import com.greenfox.exam.spring.SpringExamApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringExamApplication.class)
@WebAppConfiguration
@EnableWebMvc
public class SpringControllerTest {
  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @Before
  public void setup() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void testGetQuestions() throws Exception {
    mockMvc.perform(get("/questions"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$.id", is(1)))
        .andExpect(jsonPath("$.questions", hasSize(5)));
  }

  @Test
  public void testPostAnswers() throws Exception {
    String body = "{\"id\":1,\"questions\":[{\"id\":3,\"answer\":\"Green\"},{\"id\":5,\"answer\":\"16\"},{\"id\":4,\"answer\":\"4\"},{\"id\":2,\"answer\":\"Whippet\"},{\"id\":8,\"answer\":\"Libra\"}]}";
    mockMvc.perform(post("/answers")
        .contentType(MediaType.APPLICATION_JSON)
        .content(body))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
  }
}