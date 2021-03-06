package com.github.vatbub.randomusers.data;

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


import com.github.vatbub.randomusers.result.Nationality;

import java.util.*;

/**
 * Represents all lists for a particular nationality
 */
public class DataSet {
    private static final Map<Nationality, DataSet> dataCache = new HashMap<>();
    private List<String> cities;
    private List<String> femaleFirst;
    private List<String> maleFirst;
    private List<String> last;
    private List<String> states;

    private List<String> street;

    /**
     * Loads the data set for the specific {@link Nationality}. Data sets are cached once loaded to allow quicker access.
     *
     * @param nationality The {@link Nationality} to load the data set for
     * @return The data set for that {@link Nationality}
     */
    public static DataSet load(Nationality nationality) {
        if (!dataCache.containsKey(nationality)) {
            dataCache.put(nationality, DataSet.loadWithoutCache(nationality));
        }

        return dataCache.get(nationality);
    }

    /**
     * Loads the data set for the specific {@link Nationality} from the disk. Does not use the cache.
     *
     * @param nationality The {@link Nationality} to load the data set for
     * @return The data set for that {@link Nationality}
     */
    public static DataSet loadWithoutCache(Nationality nationality) {
        DataSet res = new DataSet();

        String resourcePackage = nationality.getShortCode() + "/lists";

        Scanner scanner = new Scanner(DataSet.class.getResourceAsStream(resourcePackage + "/cities.txt"), "UTF-8");
        res.cities = new ArrayList<>();
        while (scanner.hasNextLine()) {
            res.cities.add(scanner.nextLine());
        }

        scanner = new Scanner(DataSet.class.getResourceAsStream(resourcePackage + "/female_first.txt"), "UTF-8");
        res.femaleFirst = new ArrayList<>();
        while (scanner.hasNextLine()) {
            res.femaleFirst.add(scanner.nextLine());
        }

        scanner = new Scanner(DataSet.class.getResourceAsStream(resourcePackage + "/male_first.txt"), "UTF-8");
        res.maleFirst = new ArrayList<>();
        while (scanner.hasNextLine()) {
            res.maleFirst.add(scanner.nextLine());
        }

        scanner = new Scanner(DataSet.class.getResourceAsStream(resourcePackage + "/last.txt"), "UTF-8");
        res.last = new ArrayList<>();
        while (scanner.hasNextLine()) {
            res.last.add(scanner.nextLine());
        }

        scanner = new Scanner(DataSet.class.getResourceAsStream(resourcePackage + "/states.txt"), "UTF-8");
        res.states = new ArrayList<>();
        while (scanner.hasNextLine()) {
            res.states.add(scanner.nextLine());
        }

        scanner = new Scanner(DataSet.class.getResourceAsStream(resourcePackage + "/street.txt"), "UTF-8");
        res.street = new ArrayList<>();
        while (scanner.hasNextLine()) {
            res.street.add(scanner.nextLine());
        }

        return res;
    }

    public List<String> getCities() {
        return cities;
    }

    public List<String> getFemaleFirst() {
        return femaleFirst;
    }

    public List<String> getMaleFirst() {
        return maleFirst;
    }

    public List<String> getLast() {
        return last;
    }

    public List<String> getStates() {
        return states;
    }

    public List<String> getStreet() {
        return street;
    }

    /**
     * Represents a data set that holds data that is common for all {@link Nationality nationalities}.
     */
    public static class CommonDataSet {
        private static List<String> passwords;
        private static List<String> title;
        private static List<String> user1;
        private static List<String> user2;

        private static void loadPasswords() {
            Scanner scanner = new Scanner(DataSet.class.getResourceAsStream("common/lists/passwords.txt"), "UTF-8");
            passwords = new ArrayList<>();
            while (scanner.hasNextLine()) {
                passwords.add(scanner.nextLine());
            }
        }

        private static void loadTitle() {
            Scanner scanner = new Scanner(DataSet.class.getResourceAsStream("common/lists/title.txt"), "UTF-8");
            title = new ArrayList<>();
            while (scanner.hasNextLine()) {
                title.add(scanner.nextLine());
            }
        }

        private static void loadUser1() {
            Scanner scanner = new Scanner(DataSet.class.getResourceAsStream("common/lists/user1.txt"), "UTF-8");
            user1 = new ArrayList<>();
            while (scanner.hasNextLine()) {
                user1.add(scanner.nextLine());
            }
        }

        private static void loadUser2() {
            Scanner scanner = new Scanner(DataSet.class.getResourceAsStream("common/lists/user2.txt"), "UTF-8");
            user2 = new ArrayList<>();
            while (scanner.hasNextLine()) {
                user2.add(scanner.nextLine());
            }
        }

        public static List<String> getPasswords() {
            if (passwords == null)
                loadPasswords();
            return passwords;
        }

        public static List<String> getTitle() {
            if (title == null)
                loadTitle();
            return title;
        }

        public static List<String> getUser1() {
            if (user1 == null)
                loadUser1();
            return user1;
        }

        public static List<String> getUser2() {
            if (user2 == null)
                loadUser2();
            return user2;
        }
    }
}
