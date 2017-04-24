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


import com.github.vatbub.randomusers.data.DataSet;
import com.github.vatbub.randomusers.internal.Random;

/**
 * The postal address of a {@link RandomUser}
 */
@SuppressWarnings("unused")
public class Location {
    private String street;
    private String city;
    private String state;
    private String postCode;

    public static Location generateRandomDefaultLocation(Nationality nationality) {
        Location res = new Location();

        res.setStreet(Random.range(1000, 9999) + " " + Random.randomItem(DataSet.load(nationality).getStreet().toArray()));
        res.setCity((String) Random.randomItem(DataSet.load(nationality).getCities().toArray()));
        res.setState((String) Random.randomItem(DataSet.load(nationality).getStates().toArray()));
        res.setPostCode(String.valueOf(Random.range(10000, 99999)));

        return res;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Location)) {
            return false;
        } else {
            Location cast = (Location) obj;
            return cast.getStreet().equals(getStreet()) &&
                    cast.getCity().equals(getCity()) &&
                    cast.getState().equals(getState()) &&
                    cast.getPostCode().equals(getPostCode());
        }
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        return getStreet() + ", " + getPostCode() + " " + getCity() + ", " + getState();
    }
}
