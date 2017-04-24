package com.github.vatbub.randomusers.internal;

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
