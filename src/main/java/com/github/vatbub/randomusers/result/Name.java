package com.github.vatbub.randomusers.result;

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
     * @param gender The {@link Gender} to pick a name for
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
