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


import com.github.vatbub.randomusers.internal.Random;

import java.util.Locale;

/**
 * A list of possible nationalities for {@link RandomUser}s
 */
public abstract class Nationality {
    // australian, brazilian, canadian, swiss, german, danish, spanish, finnish, french, british, irish, iranian, dutch, new_zealand, turkish, american, lego;

    /**
     * Converts the current default locale to a {@link Nationality}
     *
     * @return The {@link Nationality} that represents the current default Locale
     */
    public static Nationality getFromCurrentDefaultLocale() {
        Locale currentLocale = Locale.getDefault();
        if (currentLocale.equals(Locale.ENGLISH) || currentLocale.equals(Locale.UK)) {
            return new Nationality.British();
        } else if (currentLocale.equals(Locale.CANADA) || currentLocale.equals(Locale.CANADA_FRENCH)) {
            return new Nationality.Canadian();
        } else if (currentLocale.equals(Locale.FRANCE) || currentLocale.equals(Locale.FRENCH)) {
            return new Nationality.French();
        } else if (currentLocale.equals(Locale.GERMAN) || currentLocale.equals(Locale.GERMANY)) {
            return new Nationality.German();
        } else if (currentLocale.equals(Locale.US)) {
            return new Nationality.American();
        } else {
            return new Nationality.American();
        }
    }

    abstract String getShortCode();

    abstract String generatePhoneNumber();

    abstract String generateCellPhoneNumber();

    abstract Location generateLocation();

    abstract Name generateName(Gender gender);

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Nationality && ((Nationality) obj).getShortCode().equals(this.getShortCode());
    }

    static class Australian extends Nationality {

        @Override
        public String getShortCode() {
            return "AU";
        }

        @Override
        public String generatePhoneNumber() {
            return "0" + Random.range(0, 9) + "-" + Random.range(0, 9) + Random.random(Random.RandomMode.numbers, 3) + "-" + Random.random(Random.RandomMode.numbers, 4);
        }

        @Override
        public String generateCellPhoneNumber() {
            return "04" + Random.random(Random.RandomMode.numbers, 2) + "-" + Random.random(Random.RandomMode.numbers, 3) + "-" + Random.random(Random.RandomMode.numbers, 3);
        }

        @Override
        public Location generateLocation() {
            Location res = Location.generateRandomDefaultLocation(this);
            res.setPostCode(String.valueOf(Random.range(200, 9999)));
            res.setStreet(res.getStreet().replace("(\\d+)", Integer.toString(Random.range(1, 9999))));
            return res;
        }

        @Override
        public Name generateName(Gender gender) {
            return Name.generateDefaultName(gender, this);
        }
    }

    static class Brazilian extends Nationality {

        @Override
        public String getShortCode() {
            return "BR";
        }

        @Override
        public String generatePhoneNumber() {
            return "(" + Random.random(Random.RandomMode.numbers, 2) + ") " + Random.random(Random.RandomMode.numbers, 4) + "-" + Random.random(Random.RandomMode.numbers, 4);
        }

        @Override
        public String generateCellPhoneNumber() {
            return "(" + Random.random(Random.RandomMode.numbers, 2) + ") " + Random.random(Random.RandomMode.numbers, 4) + "-" + Random.random(Random.RandomMode.numbers, 4);
        }

        @Override
        public Location generateLocation() {
            return Location.generateRandomDefaultLocation(this);
        }

        @Override
        public Name generateName(Gender gender) {
            return Name.generateDefaultName(gender, this);
        }
    }

    static class Canadian extends Nationality {

        @Override
        public String getShortCode() {
            return "CA";
        }

        @Override
        public String generatePhoneNumber() {
            return Random.random(Random.RandomMode.numbers, 3) + '-' + Random.random(Random.RandomMode.numbers, 3) + '-' + Random.random(Random.RandomMode.numbers, 4);
        }

        @Override
        public String generateCellPhoneNumber() {
            return Random.random(Random.RandomMode.numbers, 3) + '-' + Random.random(Random.RandomMode.numbers, 3) + '-' + Random.random(Random.RandomMode.numbers, 4);
        }

        @Override
        public Location generateLocation() {
            return Location.generateRandomDefaultLocation(this);
        }

        @Override
        public Name generateName(Gender gender) {
            return Name.generateDefaultName(gender, this);
        }
    }

    static class Swiss extends Nationality {

        @Override
        public String getShortCode() {
            return "CH";
        }

        @Override
        public String generatePhoneNumber() {
            return '(' + Random.random(Random.RandomMode.numbers, 3) + ")-" + Random.random(Random.RandomMode.numbers, 3) + '-' + Random.random(Random.RandomMode.numbers, 4);
        }

        @Override
        public String generateCellPhoneNumber() {
            return '(' + Random.random(Random.RandomMode.numbers, 3) + ")-" + Random.random(Random.RandomMode.numbers, 3) + '-' + Random.random(Random.RandomMode.numbers, 4);
        }

        @Override
        public Location generateLocation() {
            Location res = Location.generateRandomDefaultLocation(this);
            res.setPostCode(String.valueOf(Random.range(1000, 9999)));
            return res;
        }

        @Override
        public Name generateName(Gender gender) {
            Name res = Name.generateDefaultName(gender, this);
            String[] titles = {"mademoiselle", "madame", "monsieur"};
            res.setTitle((String) Random.randomItem(titles));
            return res;
        }
    }

    static class German extends Nationality {
        @Override
        public String getShortCode() {
            return "DE";
        }

        @Override
        public String generatePhoneNumber() {
            return '0' + Random.random(Random.RandomMode.numbers, 3) + '-' + Random.random(Random.RandomMode.numbers, 7);
        }

        @Override
        public String generateCellPhoneNumber() {
            return "017" + Random.random(Random.RandomMode.numbers, 1) + '-' + Random.random(Random.RandomMode.numbers, 7);
        }

        @Override
        public Location generateLocation() {
            return Location.generateRandomDefaultLocation(this);
        }

        @Override
        public Name generateName(Gender gender) {
            return Name.generateDefaultName(gender, this);
        }
    }

    static class Danish extends Nationality {

        @Override
        public String getShortCode() {
            return "DK";
        }

        @Override
        public String generatePhoneNumber() {
            return Random.random(Random.RandomMode.numbers, 8);
        }

        @Override
        public String generateCellPhoneNumber() {
            return Random.random(Random.RandomMode.numbers, 8);
        }

        @Override
        public Location generateLocation() {
            return Location.generateRandomDefaultLocation(this);
        }

        @Override
        public Name generateName(Gender gender) {
            return Name.generateDefaultName(gender, this);
        }
    }

    static class Spanish extends Nationality {

        @Override
        public String getShortCode() {
            return "ES";
        }

        @Override
        public String generatePhoneNumber() {
            return '9' + Random.random(Random.RandomMode.numbers, 2) + '-' + Random.random(Random.RandomMode.numbers, 3) + '-' + Random.random(Random.RandomMode.numbers, 3);
        }

        @Override
        public String generateCellPhoneNumber() {
            return '6' + Random.random(Random.RandomMode.numbers, 2) + '-' + Random.random(Random.RandomMode.numbers, 3) + '-' + Random.random(Random.RandomMode.numbers, 3);
        }

        @Override
        public Location generateLocation() {
            return Location.generateRandomDefaultLocation(this);
        }

        @Override
        public Name generateName(Gender gender) {
            return Name.generateDefaultName(gender, this);
        }
    }

    static class Finnish extends Nationality {

        @Override
        public String getShortCode() {
            return "FI";
        }

        @Override
        public String generatePhoneNumber() {
            return '0' + Random.range(2, 9) + '-' + Random.random(Random.RandomMode.numbers, 3) + '-' + Random.random(Random.RandomMode.numbers, 3);
        }

        @Override
        public String generateCellPhoneNumber() {
            return "04" + Random.range(0, 9) + '-' + Random.random(Random.RandomMode.numbers, 3) + '-' + Random.random(Random.RandomMode.numbers, 2) + '-' + Random.random(Random.RandomMode.numbers, 2);
        }

        @Override
        public Location generateLocation() {
            return Location.generateRandomDefaultLocation(this);
        }

        @Override
        public Name generateName(Gender gender) {
            return Name.generateDefaultName(gender, this);
        }
    }

    static class French extends Nationality {

        @Override
        public String getShortCode() {
            return "FR";
        }

        @Override
        public String generatePhoneNumber() {
            return '0' + Random.range(1, 5) + '-' + Random.random(Random.RandomMode.numbers, 2) + '-' + Random.random(Random.RandomMode.numbers, 2) + '-' + Random.random(Random.RandomMode.numbers, 2) + '-' + Random.random(Random.RandomMode.numbers, 2);
        }

        @Override
        public String generateCellPhoneNumber() {
            return "06-" + Random.random(Random.RandomMode.numbers, 2) + '-' + Random.random(Random.RandomMode.numbers, 2) + '-' + Random.random(Random.RandomMode.numbers, 2) + '-' + Random.random(Random.RandomMode.numbers, 2);
        }

        @Override
        public Location generateLocation() {
            return Location.generateRandomDefaultLocation(this);
        }

        @Override
        public Name generateName(Gender gender) {
            return Name.generateDefaultName(gender, this);
        }
    }

    static class British extends Nationality {

        @Override
        public String getShortCode() {
            return "GB";
        }

        @Override
        public String generatePhoneNumber() {
            String[] phones = {
                    "01" + Random.random(Random.RandomMode.numbers, 3) + ' ' + Random.random(Random.RandomMode.numbers, 5),
                    "01" + Random.random(Random.RandomMode.numbers, 3) + ' ' + Random.random(Random.RandomMode.numbers, 6),
                    "011" + Random.random(Random.RandomMode.numbers, 1) + Random.random(Random.RandomMode.numbers, 3) + ' ' + Random.random(Random.RandomMode.numbers, 3) + ' ' + Random.random(Random.RandomMode.numbers, 4),
                    "01" + Random.random(Random.RandomMode.numbers, 1) + "1 " + Random.random(Random.RandomMode.numbers, 3) + ' ' + Random.random(Random.RandomMode.numbers, 4),
                    "013873" + ' ' + Random.random(Random.RandomMode.numbers, 5),
                    "015242" + ' ' + Random.random(Random.RandomMode.numbers, 5),
                    "015394" + ' ' + Random.random(Random.RandomMode.numbers, 5),
                    "015395" + ' ' + Random.random(Random.RandomMode.numbers, 5),
                    "015396" + ' ' + Random.random(Random.RandomMode.numbers, 5),
                    "016973" + ' ' + Random.random(Random.RandomMode.numbers, 5),
                    "016974" + ' ' + Random.random(Random.RandomMode.numbers, 5),
                    "016977" + ' ' + Random.random(Random.RandomMode.numbers, 4),
                    "016977" + ' ' + Random.random(Random.RandomMode.numbers, 5),
                    "017683" + ' ' + Random.random(Random.RandomMode.numbers, 5),
                    "017684" + ' ' + Random.random(Random.RandomMode.numbers, 5),
                    "017687" + ' ' + Random.random(Random.RandomMode.numbers, 5),
                    "019467" + ' ' + Random.random(Random.RandomMode.numbers, 5),
                    "02" + Random.random(Random.RandomMode.numbers, 1) + ' ' + Random.random(Random.RandomMode.numbers, 4) + ' ' + Random.random(Random.RandomMode.numbers, 4)
            };

            return (String) Random.randomItem(phones);
        }

        @Override
        public String generateCellPhoneNumber() {
            return "07" + Random.random(Random.RandomMode.numbers, 2) + '-' + Random.random(Random.RandomMode.numbers, 3) + '-' + Random.random(Random.RandomMode.numbers, 3);
        }

        @Override
        public Location generateLocation() {
            Location res = Location.generateRandomDefaultLocation(this);

            String code = "ABDEFGHJLNPQRSTUWXYZ";

            String[] postcodes = {
                    Random.random(Random.RandomMode.upper, 1) + Random.random(Random.RandomMode.numbers, 1) + ' ' + Random.random(Random.RandomMode.numbers, 1) + code.charAt(Random.range(0, 19)) + code.charAt(Random.range(0, 19)),
                    Random.random(Random.RandomMode.upper, 2) + Random.random(Random.RandomMode.numbers, 1) + ' ' + Random.random(Random.RandomMode.numbers, 1) + code.charAt(Random.range(0, 19)) + code.charAt(Random.range(0, 19)),
                    Random.random(Random.RandomMode.upper, 1) + Random.random(Random.RandomMode.numbers, 2) + ' ' + Random.random(Random.RandomMode.numbers, 1) + code.charAt(Random.range(0, 19)) + code.charAt(Random.range(0, 19)),
                    Random.random(Random.RandomMode.upper, 2) + Random.random(Random.RandomMode.numbers, 2) + ' ' + Random.random(Random.RandomMode.numbers, 1) + code.charAt(Random.range(0, 19)) + code.charAt(Random.range(0, 19)),
                    Random.random(Random.RandomMode.upper, 2) + Random.random(Random.RandomMode.numbers, 1) + Random.random(Random.RandomMode.upper, 1) + ' ' + Random.random(Random.RandomMode.numbers, 1) + code.charAt(Random.range(0, 19)) + code.charAt(Random.range(0, 19)),
                    Random.random(Random.RandomMode.upper, 1) + Random.random(Random.RandomMode.numbers, 1) + Random.random(Random.RandomMode.upper, 1) + ' ' + Random.random(Random.RandomMode.numbers, 1) + code.charAt(Random.range(0, 19)) + code.charAt(Random.range(0, 19))
            };

            res.setPostCode((String) Random.randomItem(postcodes));

            return res;
        }

        @Override
        public Name generateName(Gender gender) {
            return Name.generateDefaultName(gender, this);
        }
    }

    static class Irish extends Nationality {

        @Override
        public String getShortCode() {
            return "IE";
        }

        @Override
        public String generatePhoneNumber() {
            return '0' + Random.range(1, 7) + "1-" + Random.random(Random.RandomMode.numbers, 3) + '-' + Random.random(Random.RandomMode.numbers, 4);
        }

        @Override
        public String generateCellPhoneNumber() {
            return "081-" + Random.random(Random.RandomMode.numbers, 3) + '-' + Random.random(Random.RandomMode.numbers, 4);
        }

        @Override
        public Location generateLocation() {
            return Location.generateRandomDefaultLocation(this);
        }

        @Override
        public Name generateName(Gender gender) {
            return Name.generateDefaultName(gender, this);
        }
    }

    static class Iranian extends Nationality {

        @Override
        public String getShortCode() {
            return "IR";
        }

        @Override
        public String generatePhoneNumber() {
            return '0' + Random.random(Random.RandomMode.numbers, 2) + '-' + Random.random(Random.RandomMode.numbers, 8);
        }

        @Override
        public String generateCellPhoneNumber() {
            return "09" + Random.random(Random.RandomMode.numbers, 2) + '-' + Random.random(Random.RandomMode.numbers, 3) + '-' + Random.random(Random.RandomMode.numbers, 4);
        }

        @Override
        public Location generateLocation() {
            return Location.generateRandomDefaultLocation(this);
        }

        @Override
        public Name generateName(Gender gender) {
            return Name.generateDefaultName(gender, this);
        }
    }

    static class Dutch extends Nationality {

        @Override
        public String getShortCode() {
            return "NL";
        }

        @Override
        public String generatePhoneNumber() {
            return '(' + Random.random(Random.RandomMode.numbers, 3) + ")-" + Random.random(Random.RandomMode.numbers, 3) + "-" + Random.random(Random.RandomMode.numbers, 4);
        }

        @Override
        public String generateCellPhoneNumber() {
            return '(' + Random.random(Random.RandomMode.numbers, 3) + ")-" + Random.random(Random.RandomMode.numbers, 3) + '-' + Random.random(Random.RandomMode.numbers, 4);
        }

        @Override
        public Location generateLocation() {
            return Location.generateRandomDefaultLocation(this);
        }

        @Override
        public Name generateName(Gender gender) {
            return Name.generateDefaultName(gender, this);
        }
    }

    static class New_zealand extends Nationality {
        @Override
        public String getShortCode() {
            return "NZ";
        }

        @Override
        public String generatePhoneNumber() {
            return '(' + Random.random(Random.RandomMode.numbers, 3) + ")-" + Random.random(Random.RandomMode.numbers, 3) + "-" + Random.random(Random.RandomMode.numbers, 4);
        }

        @Override
        public String generateCellPhoneNumber() {
            return '(' + Random.random(Random.RandomMode.numbers, 3) + ")-" + Random.random(Random.RandomMode.numbers, 3) + '-' + Random.random(Random.RandomMode.numbers, 4);
        }

        @Override
        public Location generateLocation() {
            return Location.generateRandomDefaultLocation(this);
        }

        @Override
        public Name generateName(Gender gender) {
            return Name.generateDefaultName(gender, this);
        }
    }

    static class Turkish extends Nationality {
        @Override
        public String getShortCode() {
            return "TR";
        }

        @Override
        public String generatePhoneNumber() {
            return '(' + Random.random(Random.RandomMode.numbers, 3) + ")-" + Random.random(Random.RandomMode.numbers, 3) + '-' + Random.random(Random.RandomMode.numbers, 4);
        }

        @Override
        public String generateCellPhoneNumber() {
            return '(' + Random.random(Random.RandomMode.numbers, 3) + ")-" + Random.random(Random.RandomMode.numbers, 3) + '-' + Random.random(Random.RandomMode.numbers, 4);
        }

        @Override
        public Location generateLocation() {
            return Location.generateRandomDefaultLocation(this);
        }

        @Override
        public Name generateName(Gender gender) {
            return Name.generateDefaultName(gender, this);
        }
    }

    static class American extends Nationality {
        @Override
        public String getShortCode() {
            return "US";
        }

        @Override
        public String generatePhoneNumber() {
            return '(' + Random.random(Random.RandomMode.numbers, 3) + ")-" + Random.random(Random.RandomMode.numbers, 3) + '-' + Random.random(Random.RandomMode.numbers, 4);
        }

        @Override
        public String generateCellPhoneNumber() {
            return '(' + Random.random(Random.RandomMode.numbers, 3) + ")-" + Random.random(Random.RandomMode.numbers, 3) + '-' + Random.random(Random.RandomMode.numbers, 4);
        }

        @Override
        public Location generateLocation() {
            return Location.generateRandomDefaultLocation(this);
        }

        @Override
        public Name generateName(Gender gender) {
            return Name.generateDefaultName(gender, this);
        }
    }

    @SuppressWarnings("unused")
    static class Lego extends Nationality {

        @SuppressWarnings("unused")
        @Override
        public String getShortCode() {
            return "LEGO";
        }

        @SuppressWarnings("unused")
        @Override
        public String generatePhoneNumber() {
            return '(' + Random.random(Random.RandomMode.numbers, 3) + ")-" + Random.random(Random.RandomMode.numbers, 3) + '-' + Random.random(Random.RandomMode.numbers, 4);
        }

        @SuppressWarnings("unused")
        @Override
        public String generateCellPhoneNumber() {
            return '(' + Random.random(Random.RandomMode.numbers, 3) + ")-" + Random.random(Random.RandomMode.numbers, 3) + '-' + Random.random(Random.RandomMode.numbers, 4);
        }

        @SuppressWarnings("unused")
        @Override
        public Location generateLocation() {
            return Location.generateRandomDefaultLocation(this);
        }

        @SuppressWarnings("unused")
        @Override
        public Name generateName(Gender gender) {
            return Name.generateDefaultName(gender, this);
        }
    }

}
