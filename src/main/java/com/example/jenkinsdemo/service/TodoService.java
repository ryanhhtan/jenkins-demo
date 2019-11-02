package com.example.jenkinsdemo.service;

import java.util.Collection;
import com.example.jenkinsdemo.model.Todo;
import com.example.jenkinsdemo.util.RandomString;
import org.springframework.stereotype.Service;

/**
 * TodoService
 */
@Service
public class TodoService implements ResourceService<Todo, Long> {

  @Override
  public Todo findById(Long id) {
    return Todo.builder().id(id).title(RandomString.make()).build();
  }

  @Override
  public Collection<Todo> findAll() {
    return null;
  }

  @Override
  public Todo update(Long id, Todo toUpdate) {
    return null;
  }

  @Override
  public void delete(Long id) {
  }

  
}
