package com.github.vatbub.randomusers.result;

import org.junit.Assert;
import org.junit.Test;

public class LocationTest {
    @Test
    public void illegalEqualsTest() {
        //noinspection EqualsBetweenInconvertibleTypes
        Assert.assertFalse(Location.generateRandomDefaultLocation(new Nationality.German()).equals(""));
    }

    @Test
    public void toStringTest() {
        Location location = Location.generateRandomDefaultLocation(new Nationality.German());
        Assert.assertEquals(location.getStreet() + ", " + location.getPostCode() + " " + location.getCity() + ", " + location.getState(), location.toString());
    }
}
