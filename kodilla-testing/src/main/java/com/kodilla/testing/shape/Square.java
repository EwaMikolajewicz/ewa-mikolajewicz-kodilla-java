package com.kodilla.testing.shape;

import java.util.Objects;

public class Square implements Shape {

    double sideLength;
    double field;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(square.sideLength, sideLength) == 0;
    }

    public Square(double sideLength) {
        this.sideLength = sideLength;
        this.field = sideLength * sideLength;
    }

    public String getShapeName() {
        return "square";
    }

    public double getField() {
        return field;
    }
}