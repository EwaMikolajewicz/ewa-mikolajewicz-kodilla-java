package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShapeCollector {

    private ArrayList<Shape> shapes = new ArrayList<Shape>();

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        return shapes.remove(shape);
    }

    public Shape getFigure(int indexN) {
        return shapes.get(indexN);
    }

    public List<Shape> showFigures() {
        for (Shape shape : shapes) {
            System.out.println("Figure: " + shape.getShapeName() + ", its field equals: " + shape.getField());
        }
        return shapes;
    }

    public int getFiguresQuantity() {
        return shapes.size();
    }
}

