package com.kodilla.spring;

import com.kodilla.spring.shape.Circle;
import com.kodilla.spring.shape.Shape;
import com.kodilla.spring.shape.Triangle;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringRunnerTestSuite {
    @Test
    public void testCircleLoadedIntoContainer(){
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Shape shape = context.getBean(Circle.class);

        //When
        String name= shape.getShapeName();

        //Then
        Assert.assertEquals("This is a circle", name);
    }

    @Test
    public void testTriangleLoadedIntoContainer(){
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Shape shape = context.getBean(Triangle.class);

        //When
        String name= shape.getShapeName();

        //Then
        Assert.assertEquals("This is a triangle", name);
    }
}
