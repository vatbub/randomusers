package com.github.vatbub.randomusers.result;

import java.util.Date;

/**
 * Created by Frederik on 21/04/2017.
 */
@SuppressWarnings("unused")
public class RandomUser {
    private Gender gender;
    private Name name;
    private Location location;
    private String email;
    private Login login;
    private Date dateOfBirth;
    private Date registrationDate;
    private String phone;
    private String cell;
    private AvatarPicture picture;
    private Nationality nationality;

    public RandomUser(Gender gender, Name name, Location location, String email, Login login, Date dateOfBirth, Date registrationDate, String phone, String cell, AvatarPicture picture, Nationality nationality){
        setGender(gender);
        setName(name);
        setLocation(location);
        setEmail(email);
        setLogin(login);
        setDateOfBirth(dateOfBirth);
        setRegistrationDate(registrationDate);
        setPhone(phone);
        setCell(cell);
        setPicture(picture);
        setNationality(nationality);
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public AvatarPicture getPicture() {
        return picture;
    }

    public void setPicture(AvatarPicture picture) {
        this.picture = picture;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }
}
