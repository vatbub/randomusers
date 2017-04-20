package com.github.vatbub.randomusers.result;

/**
 * The postal address of a {@link RandomUser}
 */
@SuppressWarnings("unused")
public class Location {
    private String street;
    private String city;
    private String state;
    private String postCode;

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
}
