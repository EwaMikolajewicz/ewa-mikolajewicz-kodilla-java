package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public final class Continent {
    private final String continentName;
    private Set<Country> continentCountries;

    public Continent(final String continentName, HashSet<Country> continentCountries) {
        this.continentName = continentName;
        this.continentCountries = continentCountries;
    }

    public Set<Country> getContinentCountries() {
        return continentCountries;
    }

    public BigDecimal getPeopleQuantity(){
        return continentCountries.stream().
                map(Country::getPeopleQuantity).
                reduce(BigDecimal.ZERO,(sum, current)->sum = sum.add(current));
    }

    @Override
    public String toString() {
        return "Continent: " +
                "\ncontinentName: " + continentName +
                "\ncontinentCountries: " + continentCountries;
    }
}
