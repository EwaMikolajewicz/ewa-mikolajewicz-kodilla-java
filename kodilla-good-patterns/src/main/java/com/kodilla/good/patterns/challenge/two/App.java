package com.kodilla.good.patterns.challenge.two;

import java.util.Scanner;

public class App {

    public static void main(String[] args) throws RouteNotFoundException {

        FlightBase flightBase = new FlightBase();
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose option:\n1. find flight from...\n2. find flight to...\n3. find flight from-to through...");
        int choice = scan.nextInt();

        int number = choice;
        switch (number) {
            case 1:
                Scanner scan1 = new Scanner(System.in);
                System.out.println("Write departure city, and click enter.\n");
                String departure = scan1.nextLine();
                flightBase.getArrivalCitiesFrom(departure);
                break;

            case 2:
                Scanner scan2 = new Scanner(System.in);
                System.out.println("Write arrival city, and click enter.\n");
                String arrival = scan2.nextLine();
                flightBase.getDepartureCitiesTo(arrival);
                break;

            case 3:
                Scanner scan3 = new Scanner(System.in);
                System.out.println("Write departure city, and click enter.\n");
                String departureAirport = scan3.nextLine();
                System.out.println("Write arrival city, and click enter.\n");
                String arrivalAirport = scan3.nextLine();
                System.out.println("Write stopover city, and click enter.\n");
                String stopoverAirport = scan3.nextLine();
                if (!flightBase.isPossible(departureAirport, stopoverAirport, arrivalAirport) && !stopoverAirport.equals("")) {
                    flightBase.getArrivalCitiesFrom(departureAirport);
                    flightBase.getDepartureCitiesTo(arrivalAirport);
                }
                break;
            default: {
                System.out.println("default");
                break;
            }
        }
    }
}
