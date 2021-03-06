package com.github.vatbub.randomusers;

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


import com.github.vatbub.randomusers.internal.Random;
import com.github.vatbub.randomusers.result.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Generates {@link RandomUser}s
 */
public class Generator {
    /**
     * Generates multiple {@link RandomUser}s in a row.
     *
     * @param spec                      The specifications for the users to generate
     * @param numberOfResultsToGenerate The number of users to generate
     * @return A list that contains the specified number of {@link RandomUser}s
     * @see #generateRandomUser(RandomUser.RandomUserSpec)
     */
    public static List<RandomUser> generateRandomUsers(RandomUser.RandomUserSpec spec, int numberOfResultsToGenerate) {
        List<RandomUser> res = new ArrayList<>(numberOfResultsToGenerate);
        for (int i = 0; i < numberOfResultsToGenerate; i++) {
            res.add(generateRandomUser(spec));
        }

        return res;
    }

    /**
     * Generates one {@link RandomUser} with the specified specifications.
     *
     * @param spec The specifications for the user to generate
     * @return A random user
     * @see #generateRandomUsers(RandomUser.RandomUserSpec, int)
     */
    public static RandomUser generateRandomUser(RandomUser.RandomUserSpec spec) {
        Nationality nationality;
        Gender gender;

        if (spec.getSeed() != Long.MIN_VALUE)
            Random.setSeed(spec.getSeed());

        if (spec.getNationalities() == null) {
            nationality = generateRandomNationality();
        } else {
            nationality = (Nationality) Random.randomItem(spec.getNationalities().toArray());
        }

        if (!(nationality instanceof Nationality.Lego)) {
            if (spec.getGenders() == null) {
                gender = generateRandomGender();
            } else {
                gender = (Gender) Random.randomItem(spec.getGenders().toArray());
            }
        } else {
            // Nationality is lego so set the gender to lego too
            gender = Gender.lego;
        }

        Name name = nationality.generateName(gender);
        Location location = nationality.generateLocation();
        String email = name.getFirstName() + "." + name.getLastName().replaceAll(" ", "") + "@example.com";

        Login login;
        if (spec.getPasswordSpec() == null) {
            login = Login.generateLogin();
        } else {
            login = Login.generateLogin(spec.getPasswordSpec());
        }

        Calendar birthDateCalendar = Calendar.getInstance();
        Calendar now = Calendar.getInstance();
        birthDateCalendar.set(Calendar.YEAR, Random.range(now.get(Calendar.YEAR) - 100, now.get(Calendar.YEAR)));
        birthDateCalendar.set(Calendar.MONTH, Random.range(0, 11));
        birthDateCalendar.set(Calendar.DATE, Random.range(1, birthDateCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)));
        Date dateOfBirth = birthDateCalendar.getTime();

        Calendar registrationDateCalendar = Calendar.getInstance();
        registrationDateCalendar.set(Calendar.YEAR, Random.range(now.get(Calendar.YEAR) - 100, now.get(Calendar.YEAR)));
        registrationDateCalendar.set(Calendar.MONTH, Random.range(0, 11));
        registrationDateCalendar.set(Calendar.DATE, Random.range(1, registrationDateCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)));
        Date registrationDate = registrationDateCalendar.getTime();

        String phone = nationality.generatePhoneNumber();
        String cell = nationality.generateCellPhoneNumber();

        int imageID;

        if (gender.equals(Gender.lego)) {
            imageID = Random.range(0, 9);
        } else {
            imageID = Random.range(0, 99);
        }

        AvatarPicture picture = new AvatarPicture(imageID, gender);

        return new RandomUser(gender, name, location, email, login, dateOfBirth, registrationDate, phone, cell, picture, nationality);
    }

    /**
     * Picks a random nationality from the {@link Nationality}-class
     *
     * @return A random nationality from the {@link Nationality}-class
     */
    private static Nationality generateRandomNationality() {
        return (Nationality) Random.randomItem(new Nationality[]{new Nationality.American(), new Nationality.Australian(), new Nationality.Brazilian(), new Nationality.British(), new Nationality.Canadian(), new Nationality.Danish(), new Nationality.Dutch(), new Nationality.Finnish(), new Nationality.French(), new Nationality.German(), new Nationality.Iranian(), new Nationality.Irish(), new Nationality.New_zealand(), new Nationality.Spanish(), new Nationality.Swiss(), new Nationality.Turkish()});
    }

    /**
     * Picks a random {@link Gender}
     *
     * @return A random {@link Gender}
     */
    private static Gender generateRandomGender() {
        return (Gender) Random.randomItem(new Gender[]{Gender.male, Gender.female});
    }

    /**
     * Specifies how a {@link Login}-password shall be generated
     *
     * @see Login#generateLogin(PasswordSpec)
     */
    public static class PasswordSpec {
        private List<PasswordCharset> charsets;
        private int minLength;
        private int maxLength;

        public int getMinLength() {
            return minLength;
        }

        public void setMinLength(int minLength) {
            this.minLength = minLength;
        }

        public int getMaxLength() {
            return maxLength;
        }

        public void setMaxLength(int maxLength) {
            this.maxLength = maxLength;
        }

        /**
         * Returns the exact length if specified.
         *
         * @return Returns the exact length if specified.
         * @throws IllegalStateException if no exact length has been specified (i. e. {@link #getMinLength()} and {@link #getMaxLength()} differ
         */
        public int getExactLength() {
            if (getMinLength() != getMaxLength()) {
                throw new IllegalStateException("Exact password length not specified, specified range is " + getMinLength() + "-" + getMaxLength());
            } else {
                // min and max are equal
                return getMinLength();
            }
        }

        public void setExactLength(@SuppressWarnings("SameParameterValue") int exactLength) {
            setMinLength(exactLength);
            setMaxLength(exactLength);
        }

        public List<PasswordCharset> getCharsets() {
            return charsets;
        }

        public void setCharsets(List<PasswordCharset> charsets) {
            this.charsets = charsets;
        }

        public enum PasswordCharset {
            special, upper, lower, number;

            public static String getAvailableChars(List<PasswordCharset> charsets) {
                StringBuilder res = new StringBuilder();
                for (PasswordCharset charset : charsets) {
                    res.append(getAvailableChars(charset));
                }
                return res.toString();
            }

            public static String getAvailableChars(PasswordCharset charset) {
                String res = "";
                switch (charset) {
                    case special:
                        res = "!\"#$%&'()*+,- ./:;<=>?@[\\]^_`{|}~";
                        break;
                    case upper:
                        res = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                        break;
                    case lower:
                        res = "abcdefghijklmnopqrstuvwxyz";
                        break;
                    case number:
                        res = "0123456789";
                        break;
                }
                return res;
            }
        }
    }
}
