package com.github.vatbub.randomusers.internal;

/**
 * Various random functions required in the api. They are meant to be used internally, don't call them directly.
 */
public class Random {
    private static java.util.Random randomNumberGenerator = new java.util.Random();
    public static String random(RandomMode mode, int length) {
        String chars = "";
        StringBuilder res = new StringBuilder();

        switch (mode) {
            case lower:
                chars = "abcdef1234567890";
                break;
            case lowerUpperNumbers:
                chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
                break;
            case numbers:
                chars = "0123456789";
                break;
            case upper:
                chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                break;
        }

        for (int i = 0; i < length; i++) {
            res.append(chars.charAt((int) Math.round(randomNumberGenerator.nextDouble() * (chars.length() - 1))));
        }

        return res.toString();
    }

    public static int range(int from, int to) {
        if (to < from) {
            throw new IllegalArgumentException("to must be higher than from (from: " + from + ", to:" + to);
        }
        return (int) (Math.round(randomNumberGenerator.nextDouble() * (to - from)) + from);
    }

    /**
     * Returns a random item from the array
     *
     * @param array The array to return an item from
     * @return A random item from the array
     */
    public static Object randomItem(Object[] array) {
        return array[Random.range(0, array.length - 1)];
    }

    @SuppressWarnings("UnnecessaryEnumModifier")
    public static enum RandomMode {
        lower, lowerUpperNumbers, upper, numbers
    }
    
    public static void setSeed(long seed){
        randomNumberGenerator = new java.util.Random(seed);
    }
}
