package com.github.vatbub.randomusers.data;

import com.github.vatbub.randomusers.result.Nationality;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents all lists for a particular nationality
 */
public class DataSet {
    private List<String> cities;
    private List<String> femaleFirst;
    private List<String> maleFirst;
    private List<String> last;
    private List<String> states;
    private List<String> street;

    /**
     * Loads the data set for the specific {@link Nationality}
     * @param nationality The {@link Nationality} to load the data set for
     * @return The data set for that {@link Nationality}
     * @throws URISyntaxException If we did a bad mistake and have typos in this method
     * @throws FileNotFoundException If we did a bad mistake and did not include the resource files for that particular {@link Nationality}
     */
    public static DataSet load(Nationality nationality) throws FileNotFoundException, URISyntaxException {
        DataSet res = new DataSet();

        String resourcePackage = nationality.getShortCode() + ".lists";
        File citiesFile = new File(DataSet.class.getResource(resourcePackage + ".cities.txt").toURI());
        File femaleFirstFile = new File(DataSet.class.getResource(resourcePackage + ".female_first.txt").toURI());
        File maleFirstFile = new File(DataSet.class.getResource(resourcePackage + ".male_first.txt").toURI());
        File lastFile = new File(DataSet.class.getResource(resourcePackage + ".last.txt").toURI());
        File statesFile = new File(DataSet.class.getResource(resourcePackage + ".states.txt").toURI());
        File streetFile = new File(DataSet.class.getResource(resourcePackage + ".street.txt").toURI());

        // cities
        Scanner scanner = new Scanner(citiesFile);
        res.cities = new ArrayList<>();
        while (scanner.hasNextLine()){
            res.cities.add(scanner.nextLine());
        }

        scanner = new Scanner(femaleFirstFile);
        res.femaleFirst = new ArrayList<>();
        while (scanner.hasNextLine()){
            res.femaleFirst.add(scanner.nextLine());
        }

        scanner = new Scanner(maleFirstFile);
        res.maleFirst = new ArrayList<>();
        while (scanner.hasNextLine()){
            res.maleFirst.add(scanner.nextLine());
        }

        scanner = new Scanner(lastFile);
        res.last = new ArrayList<>();
        while (scanner.hasNextLine()){
            res.last.add(scanner.nextLine());
        }

        scanner = new Scanner(statesFile);
        res.states = new ArrayList<>();
        while (scanner.hasNextLine()){
            res.states.add(scanner.nextLine());
        }

        scanner = new Scanner(streetFile);
        res.street = new ArrayList<>();
        while (scanner.hasNextLine()){
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
}
