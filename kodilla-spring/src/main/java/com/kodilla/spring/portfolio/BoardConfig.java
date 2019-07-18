package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {

    @Autowired
    @Qualifier("toDoList")
    TaskList toDoList;

    @Autowired
    @Qualifier("doneList")
    TaskList doneList;

    @Autowired
    @Qualifier("inProgressList")
    TaskList inProgressList;


    @Bean
    public Board getBoard() {
        return new Board(toDoList, inProgressList, doneList);
    }

    @Bean (name="toDoList")
    @Scope ("prototype")
    public TaskList getToDoTaskList() {
        return new TaskList();
    }

    @Bean (name="inProgressList")
    public TaskList getInProgressList() {
        return new TaskList();
    }

    @Bean (name="doneList")
    @Scope ("prototype")
    public TaskList getDoneTaskList() {
        return new TaskList();
    }
}