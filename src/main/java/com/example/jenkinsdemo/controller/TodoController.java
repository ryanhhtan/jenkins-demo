package com.example.jenkinsdemo.controller;

import com.example.jenkinsdemo.model.Todo;
import com.example.jenkinsdemo.service.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * TodoController
 */
@RestController
@RequiredArgsConstructor
public class TodoController {
  @NonNull
  private TodoService todoService;

  @GetMapping("/todos/{id}")
  public Todo findById(@PathVariable(name = "id") final Long id) {
    return todoService.findById(id);
  }
}
