package com.kodilla.good.patterns.challenge.two;

import java.util.*;
import java.util.stream.Collectors;

public class FlightBase {
    private final Map<Flight, Boolean> flights = new HashMap<>();


    public FlightBase() {
        flights.put(new Flight("Gdańsk", "Wrocław"), true);
        flights.put(new Flight("Gdańsk", "Warszawa"), true);
        flights.put(new Flight("Gdańsk", "Kraków"), true);
        flights.put(new Flight("Gdańsk", "Pyrzowice"), false);
        flights.put(new Flight("Gdańsk", "Poznań"), true);
        flights.put(new Flight("Gdańsk", "Rzeszów"), false);
        flights.put(new Flight("Gdańsk", "Szczecin"), false);
        flights.put(new Flight("Gdańsk", "Lublin"), false);
        flights.put(new Flight("Gdańsk", "Bydgoszcz"), true);
        flights.put(new Flight("Gdańsk", "Łódź"), true);
        flights.put(new Flight("Gdańsk", "Olsztyn"), false);
        flights.put(new Flight("Gdańsk", "Zielona Góra"), false);
        flights.put(new Flight("Gdańsk", "Radom"), true);
        flights.put(new Flight("Wrocław", "Gdańsk"), false);
        flights.put(new Flight("Wrocław", "Kraków"), true);
        flights.put(new Flight("Bydgoszcz", "Gdańsk"), true);
        flights.put(new Flight("Kraków", "Gdańsk"), true);
        flights.put(new Flight("Kraków", "Warszawa"), true);
        flights.put(new Flight("Kraków", "Pyrzowice"), false);
        flights.put(new Flight("Wrocław", "Pyrzowice"), false);
        flights.put(new Flight("Wrocław", "Warszawa"), true);
        flights.put(new Flight("Wrocław", "Poznań"), true);
        flights.put(new Flight("Wrocław", "Rzeszów"), false);
        flights.put(new Flight("Wrocław", "Szczecin"), true);
        flights.put(new Flight("Wrocław", "Lublin"), false);
        flights.put(new Flight("Wrocław", "Bydgoszcz"), true);
        flights.put(new Flight("Wrocław", "Łódź"), false);
        flights.put(new Flight("Wrocław", "Olsztyn"), true);
        flights.put(new Flight("Wrocław", "Zielona Góra"), false);
        flights.put(new Flight("Wrocław", "Radom"), true);
        flights.put(new Flight("Warszawa", "Wrocław"), true);
        flights.put(new Flight("Warszawa", "Gdańsk"), false);
        flights.put(new Flight("Warszawa", "Kraków"), true);
        flights.put(new Flight("Warszawa", "Pyrzowice"), true);
        flights.put(new Flight("Warszawa", "Poznań"), false);
        flights.put(new Flight("Warszawa", "Rzeszów"), true);
        flights.put(new Flight("Warszawa", "Szczecin"), false);
        flights.put(new Flight("Warszawa", "Lublin"), false);
        flights.put(new Flight("Warszawa", "Bydgoszcz"), true);
        flights.put(new Flight("Warszawa", "Łódź"), false);
        flights.put(new Flight("Warszawa", "Olsztyn"), false);
        flights.put(new Flight("Warszawa", "Zielona Góra"), true);
        flights.put(new Flight("Warszawa", "Radom"), true);
        flights.put(new Flight("Zielona Góra", "Bydgoszcz"), true);
        flights.put(new Flight("Zielona Góra", "Gdańsk"), true);
        flights.put(new Flight("Bydgoszcz", "Wrocław"), true);
    }

    List<String> arrivalCitiesFrom = new ArrayList<>();
    List<String> departureCitiesTo = new ArrayList<>();

    List<String> getArrivalCitiesFrom(String city) {
        if (city.equals("")) {
            throw new RouteNotFoundException("You didn't enter the city");

        } else {
            flights.entrySet().stream()
                    .filter(e -> (e.getValue().equals(true) && e.getKey().getDepartureCity().contains(city)))
                    .map(Map.Entry::getKey)
                    .map(Flight::getArrivalCity)
                    .forEach(arrivalCitiesFrom::add);

            String cities = arrivalCitiesFrom.stream()
                    .collect(Collectors.joining("\n"));
            if (cities.length() == 0) {
                System.out.println("Sorry, no flights from " + city);
            } else {
                System.out.println("Available flights from " + city + " are to cities:\n" + cities);
            }
        }
        return arrivalCitiesFrom;
    }


    List<String> getDepartureCitiesTo(String city) {
        if(city.equals("")){
            throw new RouteNotFoundException("You didn't enter the city");

        } else {
            flights.entrySet().stream()
                    .filter(e -> (e.getValue().equals(true) && e.getKey().getArrivalCity().contains(city)))
                    .map(Map.Entry::getKey)
                    .map(Flight::getDepartureCity)
                    .forEach(departureCitiesTo::add);

            String cities = departureCitiesTo.stream()
                    .collect(Collectors.joining("\n"));
            if (cities.length() == 0) {
                System.out.println("Sorry, no flights to " + city);
            } else {
                System.out.println("Available flights to " + city + " are from cities:\n" + cities);
            }
        }
        return departureCitiesTo;
    }

    Set<String> citiesA = new HashSet<>();
    Set<String> citiesB = new HashSet<>();
    Set<String> citiesWAS = new HashSet<>();
    Set<String> cities = new HashSet<>();

    boolean isPossible(String departureCity, String stopoverCity, String arrivalCity) {
        if (departureCity.equals("") || arrivalCity.equals("")) {
            throw new RouteNotFoundException("You didn't enter required cities (departure or arrival).");
        } else {
            if (stopoverCity.equals("")) {
                flights.entrySet().stream()
                        .filter(e -> (e.getValue().equals(true) &&
                                e.getKey().getArrivalCity().equals(arrivalCity) &&
                                e.getKey().getDepartureCity().equals(departureCity)))
                        .map(Map.Entry::getKey)
                        .map(Flight::getArrivalCity)
                        .forEach(citiesWAS::add);
                System.out.println("Is possible direct flight from " + departureCity +
                        " to " + arrivalCity + "? " + !citiesWAS.isEmpty());
//                return !citiesWAS.isEmpty();
            } else {
                flights.entrySet().stream()
                        .filter(e -> (e.getValue().equals(true) && e.getKey().getDepartureCity().equals(departureCity)))
                        .map(Map.Entry::getKey)
                        .map(Flight::getArrivalCity)
                        .forEach(citiesA::add);
                flights.entrySet().stream()
                        .filter(a -> (a.getValue().equals(true) && a.getKey().getArrivalCity().equals(arrivalCity)))
                        .map(Map.Entry::getKey)
                        .map(Flight::getDepartureCity)
                        .forEach(citiesB::add);

                if (citiesA.contains(stopoverCity) && citiesB.contains(stopoverCity)) {
                    cities.add(stopoverCity);

                    String city = cities.stream()
                            .collect(Collectors.joining(", "));
                    if (city.length() == 0) {
                        System.out.println("Sorry, no flights through " + cities);
                    } else {
                        System.out.println("Flight from " + departureCity + " to " + arrivalCity + " through " + city + " is possible.");
                    }
//                    return !cities.isEmpty();
                }
                System.out.println("Flight from " + departureCity + " to " + arrivalCity + " through " + stopoverCity + " is impossible.");
            }
        }
        return !cities.isEmpty();
    }
}
