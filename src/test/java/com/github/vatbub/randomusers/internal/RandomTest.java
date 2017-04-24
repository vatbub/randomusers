package com.github.vatbub.randomusers.internal;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frederik on 24/04/2017.
 */
public class RandomTest {
    @Test
    public void seedTest() {
        long seed = 524367854;
        int listLength = 30;
        int rangeFrom = 0;
        int rangeTo = 500;

        Random.setSeed(seed);

        List<Integer> rangeList = new ArrayList<>(30);
        for (int i = 0; i < listLength; i++) {
            rangeList.add(Random.range(rangeFrom, rangeTo));
        }

        Random.setSeed(seed);
        for (int i = 0; i < listLength; i++) {
            assert rangeList.get(i).equals(Random.range(rangeFrom, rangeTo));
        }

        List<String> sampleStringList = new ArrayList<>(listLength);
        for (int i = 0; i < listLength; i++) {
            sampleStringList.add("\"" + i + 1 + "\"");
        }

        List<String> randomItemList = new ArrayList<>();
        Random.setSeed(seed);
        for (int i = 0; i < listLength; i++) {
            randomItemList.add((String) Random.randomItem(sampleStringList.toArray()));
        }

        Random.setSeed(seed);
        for (int i = 0; i < listLength; i++) {
            assert randomItemList.get(i).equals(Random.randomItem(sampleStringList.toArray()));
        }

        int stringLength = 400;
        Random.RandomMode mode = Random.RandomMode.numbers;
        List<String> randomList = new ArrayList<>(listLength);
        Random.setSeed(seed);
        for (int i = 0; i < listLength; i++) {
            randomList.add(Random.random(mode, stringLength));
        }

        Random.setSeed(seed);
        for (int i = 0; i < listLength; i++) {
            assert randomList.get(i).equals(Random.random(mode, stringLength));
        }

        mode = Random.RandomMode.lower;
        randomList = new ArrayList<>(listLength);
        Random.setSeed(seed);
        for (int i = 0; i < listLength; i++) {
            randomList.add(Random.random(mode, stringLength));
        }

        Random.setSeed(seed);
        for (int i = 0; i < listLength; i++) {
            assert randomList.get(i).equals(Random.random(mode, stringLength));
        }

        mode = Random.RandomMode.upper;
        randomList = new ArrayList<>(listLength);
        Random.setSeed(seed);
        for (int i = 0; i < listLength; i++) {
            randomList.add(Random.random(mode, stringLength));
        }

        Random.setSeed(seed);
        for (int i = 0; i < listLength; i++) {
            assert randomList.get(i).equals(Random.random(mode, stringLength));
        }

        mode = Random.RandomMode.lowerUpperNumbers;
        randomList = new ArrayList<>(listLength);
        Random.setSeed(seed);
        for (int i = 0; i < listLength; i++) {
            randomList.add(Random.random(mode, stringLength));
        }

        Random.setSeed(seed);
        for (int i = 0; i < listLength; i++) {
            assert randomList.get(i).equals(Random.random(mode, stringLength));
        }
    }

    @Test
    public void failingRangeTest() {
        try {
            // should throw an exception
            Random.range(50, 49);
            assert false;
        } catch (IllegalArgumentException e) {
            assert true;
        }
    }
}
