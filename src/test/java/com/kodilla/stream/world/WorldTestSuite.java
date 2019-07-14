package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashSet;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity() {
        //Given
        HashSet<Country> europeanCountries = new HashSet<>();
        HashSet<Country> asianCountries = new HashSet<>();
        HashSet<Country> africanCountries = new HashSet<>();

        Country poland = new Country("Poland", BigDecimal.valueOf(123456789));
        Country germany = new Country("Germany", BigDecimal.valueOf(321654));
        Country china = new Country("China", BigDecimal.valueOf(999999999));
        Country pakistan = new Country("Pakistan", BigDecimal.valueOf(6545632));
        Country egypt = new Country("Egypt", BigDecimal.valueOf(666666666));
        Country rpa = new Country("RPA", BigDecimal.valueOf(564668713));

        europeanCountries.add(poland);
        europeanCountries.add(germany);
        asianCountries.add(china);
        asianCountries.add(pakistan);
        africanCountries.add(egypt);
        africanCountries.add(rpa);

        Continent europe = new Continent("Europe", europeanCountries);
        Continent asia = new Continent("Asia", asianCountries);
        Continent africa = new Continent("Africa", africanCountries);

        World world = new World();

        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(africa);

        //Then
        Assert.assertEquals("2361659453", world.getPeopleQuantity().toPlainString());
        Assert.assertEquals("2361337799", world.getPeopleQuantity().subtract(germany.getPeopleQuantity()).toPlainString());
        Assert.assertEquals(new BigDecimal( "1355113822"), world.getPeopleQuantity().subtract(asia.getPeopleQuantity()));
        Assert.assertEquals("1006545631", asia.getPeopleQuantity().toPlainString());
    }
}
