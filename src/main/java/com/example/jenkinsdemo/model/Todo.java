package com.example.jenkinsdemo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

/**
 * Todo
 */
@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode
@Accessors(chain = true)
public class Todo {
  private Long id;
  private String title;
  private boolean completed;
}
