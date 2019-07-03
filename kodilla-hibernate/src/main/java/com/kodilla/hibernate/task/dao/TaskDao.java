package com.kodilla.hibernate.task.dao;


import com.kodilla.hibernate.task.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskDao extends CrudRepository<Task, Integer> {
}