package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Tasks {

    private final String taskName;
    private final String whatToBuy;
    private final double quantity;
    private int counter = 0;

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Shopping Task: " + taskName +
                ", you should buy " + quantity +
                " of " + whatToBuy;
    }

    @Override
    public Tasks executeTask() {
        counter++;
        return new ShoppingTask(taskName, whatToBuy, quantity);
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
