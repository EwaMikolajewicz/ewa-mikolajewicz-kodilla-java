package com.kodilla.patterns.factory.tasks;

public interface Tasks {
    Tasks executeTask();
    String getTaskName();
    boolean isTaskExecuted();
}
