package com.kodilla.exception.test;

import java.util.Scanner;

class IndexExceptionRunner {
    public static void main(String[] args) {

        FlightSearching flightSearching = new FlightSearching();
        Scanner scan = new Scanner(System.in);
        System.out.println("Write departure airport, and click enter.\n");
        String departureArrival = scan.nextLine();
        System.out.println("Write arrival airport, and click enter.\n");
        String arrivalArrival = scan.nextLine();
        Flight flight = new Flight(departureArrival, arrivalArrival);
        try {
            flightSearching.findFlight(flight);
        } catch (RouteNotFoundException e) {
            System.out.println("Flight wasn't found. Try again.\nFound exception: " + e);
        }
    }
}