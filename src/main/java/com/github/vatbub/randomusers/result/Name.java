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
 * The name of a {@link RandomUser}
 */
@SuppressWarnings("unused")
public class Name {
    private String title;
    private String firstName;
    private String lastName;

    /**
     * Picks a random name from the according {@link DataSet}
     *
     * @param gender      The {@link Gender} to pick a name for
     * @param nationality The {@link Nationality} of the person to pick a name for
     * @return A random name
     */
    public static Name generateDefaultName(Gender gender, Nationality nationality) {
        DataSet dataSet = DataSet.load(nationality);
        Name res = new Name();

        if (gender == Gender.male) {
            res.setTitle("mr");
            res.setFirstName((String) Random.randomItem(dataSet.getMaleFirst().toArray()));
        } else {
            res.setTitle((String) Random.randomItem(DataSet.CommonDataSet.getTitle().toArray()));
            res.setFirstName((String) Random.randomItem(dataSet.getFemaleFirst().toArray()));
        }
        res.setLastName((String) Random.randomItem(dataSet.getLast().toArray()));

        return res;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Name)) {
            return false;
        } else {
            Name cast = (Name) obj;
            return cast.getTitle().equals(getTitle()) &&
                    cast.getFirstName().equals(getFirstName()) &&
                    cast.getLastName().equals(getLastName());
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return getTitle() + ". " + getFirstName() + " " + getLastName();
    }
}
