package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearching {

    private Map<String, Boolean> flights = new HashMap<>();

    public FlightSearching() {
        flights.put("Chopin Airport", true);
        flights.put("Heathrow Airport", false);
        flights.put("Balice Airport", true);
        flights.put("Lisbona Airport", false);
    }

    public boolean findFlight(Flight flight) throws RouteNotFoundException{

        String departure = flight.getDepartureAirport();
        String arrival = flight.getArrivalAirport();

        if (!flights.containsKey(departure)) {

            throw new RouteNotFoundException("There is no departure airport in database.");

        }

        if (!flights.containsKey(arrival))
        {

            throw new RouteNotFoundException("There is no arrival airport in database.");

        }

        else {
            boolean isArrivalAvailable = flights.get(arrival);
            boolean isDepartureAvailable = flights.get(departure);
            boolean isFlightAvailable = flights.get(departure) && flights.get(arrival);
            System.out.println("Is the flight available? " + isFlightAvailable +
                    "\nIs the arrival airport available? " + isArrivalAvailable +
                    "\nIs the departure airport available? " + isDepartureAvailable);
            return isFlightAvailable;
        }
    }
}