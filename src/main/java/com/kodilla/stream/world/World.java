package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class World {
    private final Set<Continent> continents = new HashSet<>();

    public void addContinent (Continent continent){
        continents.add(continent);
    }

    @Override
    public String toString() {
        return "World: " +
                "\ncontinents: " + continents;
    }

    public BigDecimal getPeopleQuantity(){
        return continents.stream().
                flatMap(continent -> continent.getContinentCountries().stream()).
                map(Country::getPeopleQuantity).
                reduce(BigDecimal.ZERO,(sum, current)->sum = sum.add(current));
    }
}