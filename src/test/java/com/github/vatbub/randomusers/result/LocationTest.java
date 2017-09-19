package com.github.vatbub.randomusers.result;

/*-
 * #%L
 * Random Users
 * %%
 * Copyright (C) 2017 Frederik Kammel
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


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
