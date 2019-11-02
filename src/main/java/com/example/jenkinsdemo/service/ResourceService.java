package com.example.jenkinsdemo.service;

import java.util.Collection;

/**
 * ResourceService
 */
public interface ResourceService<T, ID> {
  public T findById(ID id);
  public Collection<T> findAll();
  public T update(ID id, T toUpdate);
  public void delete(ID id);
}
