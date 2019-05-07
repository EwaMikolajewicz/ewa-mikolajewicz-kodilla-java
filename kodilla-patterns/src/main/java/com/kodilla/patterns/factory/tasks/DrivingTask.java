package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Tasks {

    final String taskName;
    final String where;
    final String using;
    private int counter;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public String toString() {
        return "Driving Task: " + taskName +
                ", you should go " + where +
                " using " + using;
    }

    @Override
    public Tasks executeTask() {
        counter++;
        return new PaintingTask(taskName, where, using);
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        counter != 0;
    }
}
