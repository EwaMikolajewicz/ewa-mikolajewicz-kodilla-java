package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Tasks {

    final String taskName;
    final String color;
    final String whatToPaint;
    private int counter;

    public PaintingTask(String taskName, String color, String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    @Override
    public String toString() {
        return "Painting Task: " + taskName +
                ", you should use " + color +
                " to paint " + whatToPaint;
    }

    @Override
    public Tasks executeTask() {
        counter++;
        return new PaintingTask(taskName, color, whatToPaint);
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        if (counter == 0) {
            return false;
        } else {
            return true;
        }
    }
}
