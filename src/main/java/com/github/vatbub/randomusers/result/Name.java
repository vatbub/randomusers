package com.github.vatbub.randomusers.result;

import org.jetbrains.annotations.NotNull;

/**
 * The name of a {@link RandomUser}
 */
@SuppressWarnings("unused")
public class Name {
    private String title;
    private String firstName;
    private String lastName;


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

    public static Name generateDefaultName(){
        return new Name();
    }
}
