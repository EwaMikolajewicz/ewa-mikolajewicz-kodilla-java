package com.kodilla.patterns.factory.tasks;

public class TasksFactory {
    public static final String SHOPPING = "SHOPPING TASK";
    public static final String PAINTING = "PAINTING TASK";
    public static final String DRIVING = "DRIVING TASK";

    public final Tasks makeTask(String theTask) {
        switch (theTask) {
            case SHOPPING:
                return new ShoppingTask("Makeup shopping task", "foundation", 1.0);
            case PAINTING:
                return new PaintingTask("Living room task", "yellow", "walls");
            case DRIVING:
                return new DrivingTask("Poland journey task", "Bieszczady", "bicycle");
            default:
                return null;
        }
    }
}
