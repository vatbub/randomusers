package com.github.vatbub.randomusers.internal;

/**
 * Various random functions required in the api. They are meant to be used internally, don't call them directly.
 */
public class Random {
    private static java.util.Random randomNumberGenerator = new java.util.Random();

    /**
     * Generates a random string
     * @param mode Defines the charset to be used to generate the string
     * @param length The length of the desired string
     * @return A random string
     */
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

    /**
     * Picks a random number from the specified interval
     * @param from The minimal value of the return value
     * @param to The maximal value of the return value
     * @return A random integer that is bigger or equal to {@code from} and less or equal to {@code to}
     */
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
    /**
     * Charset for the {@link #random(RandomMode, int)}-method<br>
     * <br>
     * {@code lower}:   Lower case letters from a to z
     * {@code upper}:   Upper case letters from A to Z
     * {@code numbers}: All numbers from 0 to 9
     * {@code lowerUpperNumbers}:   Everything mentioned earlier
     */
    public static enum RandomMode {
        lower, lowerUpperNumbers, upper, numbers
    }

    /**
     * Reinitializes the random number generator with the given seed. That means that after each call to this method using the same seed, all methods of this class will return the same values again
     * @param seed The seed to use
     */
    public static void setSeed(long seed){
        randomNumberGenerator = new java.util.Random(seed);
    }
}
