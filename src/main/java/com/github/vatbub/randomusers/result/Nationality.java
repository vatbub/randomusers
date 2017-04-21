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
            res.getStreet().replace("(\\d+)", Integer.toString(Random.range(1, 9999)));
            return res;
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
    }

    class Canadian implements Nationality{

        @Override
        public String getShortCode() {
            return "CA";
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

    class Swiss implements Nationality{

        @Override
        public String getShortCode() {
            return null;
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

    class German implements Nationality{


        @Override
        public String getShortCode() {
            return null;
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

    class Danish implements Nationality{

        @Override
        public String getShortCode() {
            return null;
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

    class Spanish implements Nationality{

        @Override
        public String getShortCode() {
            return null;
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

    class Finnish implements Nationality{

        @Override
        public String getShortCode() {
            return null;
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

    class French implements Nationality{

        @Override
        public String getShortCode() {
            return null;
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

    class British implements Nationality{

        @Override
        public String getShortCode() {
            return null;
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

    class Irish implements Nationality{

        @Override
        public String getShortCode() {
            return null;
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

    class Iranian implements Nationality{

        @Override
        public String getShortCode() {
            return null;
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

    class Dutch implements Nationality{

        @Override
        public String getShortCode() {
            return null;
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

    class New_zealand implements Nationality{

        @Override
        public String getShortCode() {
            return null;
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

    class Turkish implements Nationality{

        @Override
        public String getShortCode() {
            return null;
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

    class American implements Nationality{

        @Override
        public String getShortCode() {
            return null;
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

    class Lego implements Nationality{

        @Override
        public String getShortCode() {
            return null;
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

    /*public static String getShortCode(Nationality nationality){
        String res = null;
        // AU, BR, CA, CH, DE, DK, ES, FI, FR, GB, IE, IR, NL, NZ, TR, US
        switch (nationality){
            case australian:
                res = "AU";
                break;
            case brazilian:
                res = "BR";
                break;
            case canadian:
                res = "CA";
                break;
            case swiss:
                res = "CH";
                break;
            case german:
                res = "DE";
                break;
            case danish:
                res = "DK";
                break;
            case spanish:
                res = "ES";
                break;
            case finnish:
                res = "FI";
                break;
            case french:
                res = "FR";
                break;
            case british:
                res = "GB";
                break;
            case irish:
                res = "IE";
                break;
            case iranian:
                res = "IR";
                break;
            case dutch:
                res = "NL";
                break;
            case new_zealand:
                res = "NZ";
                break;
            case turkish:
                res = "TR";
                break;
            case american:
                res = "US";
                break;
            case lego:
                res="LEGO";
                break;
        }

        return res;
    }*/
}
