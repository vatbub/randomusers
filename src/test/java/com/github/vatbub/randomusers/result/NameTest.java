package com.github.vatbub.randomusers.result;

import org.junit.Assert;
import org.junit.Test;

public class NameTest {
    @Test
    public void illegalEqualsTest() {
        //noinspection EqualsBetweenInconvertibleTypes
        Assert.assertFalse(Name.generateDefaultName(Gender.female, new Nationality.German()).equals(""));
    }

    @Test
    public void toStringTest() {
        Name name = Name.generateDefaultName(Gender.female, new Nationality.German());
        Assert.assertEquals(name.getTitle() + ". " + name.getFirstName() + " " + name.getLastName(), name.toString());
    }
}
