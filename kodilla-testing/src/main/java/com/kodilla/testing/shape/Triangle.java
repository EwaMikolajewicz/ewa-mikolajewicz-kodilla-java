package com.kodilla.testing.shape;

public class Triangle implements Shape {

    double sideTriangleLength;
    double heightLength;
    double field;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.sideTriangleLength, sideTriangleLength) == 0 &&
                Double.compare(triangle.heightLength, heightLength) == 0;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public Triangle(double sideLength, double heightLength) {
        this.sideTriangleLength = sideLength;
        this.heightLength = heightLength;
        this.field = 0.5 * sideTriangleLength * heightLength;
    }

    public String getShapeName() {
        return "triangle";
    }

    public double getField() {
        return field;
    }
}