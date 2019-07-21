package com.kodilla.good.patterns.challenge.two;

public class RouteNotFoundException extends RuntimeException {

    public RouteNotFoundException(final String message) {
        super(message);
    }
}

