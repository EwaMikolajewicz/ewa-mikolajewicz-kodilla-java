package com.kodilla.testing.shape;

import static java.lang.Math.PI;

class Circle implements Shape {

    double radius;
    double field;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    public Circle(double radius) {
        this.radius = radius;
        this.field = PI * radius * radius;
    }

    public String getShapeName() {
        return "circle";
    }

    public double getField() {
        return field;
    }
}
