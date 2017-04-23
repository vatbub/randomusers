package com.github.vatbub.randomusers.result;

import com.github.vatbub.randomusers.internal.Random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A list of possible nationalities for {@link RandomUser}s
 */
public interface Nationality {
    // australian, brazilian, canadian, swiss, german, danish, spanish, finnish, french, british, irish, iranian, dutch, new_zealand, turkish, american, lego;

    String getShortCode();

    String generatePhoneNumber();

    String generateCellPhoneNumber();

    Location generateLocation();

    Name generateName();

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
            Location res = Location.generateRandomDefaultLocation();
            res.setPostCode(String.valueOf(Random.range(200, 9999)));
            res.setStreet(res.getStreet().replace("(\\d+)", Integer.toString(Random.range(1, 9999))));
            return res;
        }

        @Override
        public Name generateName() {
            return Name.generateDefaultName();
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
            return Location.generateRandomDefaultLocation();
        }

        @Override
        public Name generateName() {
            return Name.generateDefaultName();
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
            return Location.generateRandomDefaultLocation();
        }

        @Override
        public Name generateName() {
            return Name.generateDefaultName();
        }
    }

    class Swiss implements Nationality {

        @Override
        public String getShortCode() {
            return "CH";
        }

        @Override
        public String generatePhoneNumber() {
            return null;
        }

        @Override
        public String generateCellPhoneNumber() {
            return null;
        }

        @Override
        public Location generateLocation() {
            return null;
        }

        @Override
        public Name generateName() {
            Name res = Name.generateDefaultName();
            // 'mademoiselle', 'madame'
            List<String> titles = Collections.singletonList("mademoiselle, madame, monsieur");
            res.setTitle(Random.randomItem(titles));
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
            return null;
        }

        @Override
        public String generateCellPhoneNumber() {
            return null;
        }

        @Override
        public Location generateLocation() {
            return null;
        }
    }

    class Danish implements Nationality {

        @Override
        public String getShortCode() {
            return "DK";
        }

        @Override
        public String generatePhoneNumber() {
            return null;
        }

        @Override
        public String generateCellPhoneNumber() {
            return null;
        }

        @Override
        public Location generateLocation() {
            return null;
        }
    }

    class Spanish implements Nationality {

        @Override
        public String getShortCode() {
            return "ES";
        }

        @Override
        public String generatePhoneNumber() {
            return null;
        }

        @Override
        public String generateCellPhoneNumber() {
            return null;
        }

        @Override
        public Location generateLocation() {
            return null;
        }
    }

    class Finnish implements Nationality {

        @Override
        public String getShortCode() {
            return "FI";
        }

        @Override
        public String generatePhoneNumber() {
            return null;
        }

        @Override
        public String generateCellPhoneNumber() {
            return null;
        }

        @Override
        public Location generateLocation() {
            return null;
        }
    }

    class French implements Nationality {

        @Override
        public String getShortCode() {
            return "FR";
        }

        @Override
        public String generatePhoneNumber() {
            return null;
        }

        @Override
        public String generateCellPhoneNumber() {
            return null;
        }

        @Override
        public Location generateLocation() {
            return null;
        }
    }

    class British implements Nationality {

        @Override
        public String getShortCode() {
            return "GB";
        }

        @Override
        public String generatePhoneNumber() {
            return null;
        }

        @Override
        public String generateCellPhoneNumber() {
            return null;
        }

        @Override
        public Location generateLocation() {
            return null;
        }
    }

    class Irish implements Nationality {

        @Override
        public String getShortCode() {
            return "IE";
        }

        @Override
        public String generatePhoneNumber() {
            return null;
        }

        @Override
        public String generateCellPhoneNumber() {
            return null;
        }

        @Override
        public Location generateLocation() {
            return null;
        }
    }

    class Iranian implements Nationality {

        @Override
        public String getShortCode() {
            return "IR";
        }

        @Override
        public String generatePhoneNumber() {
            return null;
        }

        @Override
        public String generateCellPhoneNumber() {
            return null;
        }

        @Override
        public Location generateLocation() {
            return null;
        }
    }

    class Dutch implements Nationality {

        @Override
        public String getShortCode() {
            return "NL";
        }

        @Override
        public String generatePhoneNumber() {
            return null;
        }

        @Override
        public String generateCellPhoneNumber() {
            return null;
        }

        @Override
        public Location generateLocation() {
            return null;
        }
    }

    class New_zealand implements Nationality {
        @Override
        public String getShortCode() {
            return "NZ";
        }

        @Override
        public String generatePhoneNumber() {
            return null;
        }

        @Override
        public String generateCellPhoneNumber() {
            return null;
        }

        @Override
        public Location generateLocation() {
            return null;
        }
    }

    class Turkish implements Nationality {
        @Override
        public String getShortCode() {
            return "TR";
        }

        @Override
        public String generatePhoneNumber() {
            return null;
        }

        @Override
        public String generateCellPhoneNumber() {
            return null;
        }

        @Override
        public Location generateLocation() {
            return null;
        }
    }

    class American implements Nationality {

        @Override
        public String getShortCode() {
            return "US";
        }

        @Override
        public String generatePhoneNumber() {
            return null;
        }

        @Override
        public String generateCellPhoneNumber() {
            return null;
        }

        @Override
        public Location generateLocation() {
            return null;
        }
    }

    class Lego implements Nationality {

        @Override
        public String getShortCode() {
            return "LEGO";
        }

        @Override
        public String generatePhoneNumber() {
            return null;
        }

        @Override
        public String generateCellPhoneNumber() {
            return null;
        }

        @Override
        public Location generateLocation() {
            return null;
        }
    }

}
