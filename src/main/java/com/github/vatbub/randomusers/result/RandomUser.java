package com.github.vatbub.randomusers.result;

import com.github.vatbub.randomusers.Generator;

import java.util.Date;
import java.util.List;

/**
 * Represents a user generated by {@link Generator#generateRandomUser(RandomUserSpec)}
 */
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

    public RandomUser(Gender gender, Name name, Location location, String email, Login login, Date dateOfBirth, Date registrationDate, String phone, String cell, AvatarPicture picture, Nationality nationality) {
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

    @Override
    public String toString() {
        return getName().toString() + ", " + getGender().toString();
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

    public static class RandomUserSpec {
        private List<Gender> genders;
        private List<Nationality> nationalities;
        private Generator.PasswordSpec passwordSpec;
        private String seed;

        public RandomUserSpec() {
            this(null, null, null, null);
        }

        @SuppressWarnings("SameParameterValue")
        public RandomUserSpec(List<Gender> genders, List<Nationality> nationalities, Generator.PasswordSpec passwordSpec, String seed) {
            setGenders(genders);
            setNationalities(nationalities);
            setPasswordSpec(passwordSpec);
            setSeed(seed);
        }

        public List<Gender> getGenders() {
            return genders;
        }

        public void setGenders(List<Gender> genders) {
            this.genders = genders;
        }

        public List<Nationality> getNationalities() {
            return nationalities;
        }

        public void setNationalities(List<Nationality> nationalities) {
            this.nationalities = nationalities;
        }

        public Generator.PasswordSpec getPasswordSpec() {
            return passwordSpec;
        }

        public void setPasswordSpec(Generator.PasswordSpec passwordSpec) {
            this.passwordSpec = passwordSpec;
        }

        public String getSeed() {
            return seed;
        }

        public void setSeed(String seed) {
            this.seed = seed;
        }
    }
}
