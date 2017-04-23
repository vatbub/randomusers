package com.github.vatbub.randomusers.result;

import com.github.vatbub.randomusers.internal.Random;

/**
 * A list of possible nationalities for {@link RandomUser}s
 */
public interface Nationality {
    // australian, brazilian, canadian, swiss, german, danish, spanish, finnish, french, british, irish, iranian, dutch, new_zealand, turkish, american, lego;

    String getShortCode();

    String generatePhoneNumber();

    String generateCellPhoneNumber();

    Location generateLocation();

    Name generateName(Gender gender);

    class Australian implements Nationality {

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

    class Brazilian implements Nationality {

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

    class Canadian implements Nationality {

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

    class Swiss implements Nationality {

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

    class German implements Nationality {
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

    class Danish implements Nationality {

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

    class Spanish implements Nationality {

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

    class Finnish implements Nationality {

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
            return null;
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

    class French implements Nationality {

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

    class British implements Nationality {

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

    class Irish implements Nationality {

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

    class Iranian implements Nationality {

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

    class Dutch implements Nationality {

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

    class New_zealand implements Nationality {
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

    class Turkish implements Nationality {
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

    class American implements Nationality {
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

    class Lego implements Nationality {

        @Override
        public String getShortCode() {
            return "LEGO";
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

}
