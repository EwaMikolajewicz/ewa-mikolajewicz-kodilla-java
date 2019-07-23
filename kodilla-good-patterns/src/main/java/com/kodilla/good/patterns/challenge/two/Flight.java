package com.kodilla.good.patterns.challenge.two;

public class Flight {
    private final String departureCity;
    private final String arrivalCity;

    public Flight(final String departureCity, final String arrivalCity) {
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    @Override
    public String toString() {
        return departureCity +" - " + arrivalCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight that = (Flight) o;
        if (!departureCity.equals(that.departureCity)) return false;
        return arrivalCity.equals(that.arrivalCity);
    }

    @Override
    public int hashCode() {
        int result = departureCity.hashCode();
        result = 31 * result + arrivalCity.hashCode();
        return result;
    }
}
