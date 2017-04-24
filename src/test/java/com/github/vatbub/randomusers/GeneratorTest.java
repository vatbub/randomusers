package com.github.vatbub.randomusers;

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
import com.github.vatbub.randomusers.result.Gender;
import com.github.vatbub.randomusers.result.Nationality;
import com.github.vatbub.randomusers.result.RandomUser;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Main {@link Generator}-Tests
 */
public class GeneratorTest {
    @Test
    public void generateOneUserTest() {
        RandomUser randomUser = Generator.generateRandomUser(new RandomUser.RandomUserSpec());
        assertUser(randomUser);
    }

    @Test
    public void generateMultipleUsersTest() {
        int numberOfUsersToGenerate = 100;
        List<RandomUser> randomUsers = Generator.generateRandomUsers(new RandomUser.RandomUserSpec(), numberOfUsersToGenerate);
        assert randomUsers.size() == numberOfUsersToGenerate;

        for (RandomUser user : randomUsers) {
            assertUser(user);
        }
    }

    @Test
    public void genderSpecTest() {
        int numberOfUsersToGenerate = 100;
        Gender genderToTest = Gender.female;
        RandomUser.RandomUserSpec spec = new RandomUser.RandomUserSpec();
        List<Gender> genders = new ArrayList<>();
        genders.add(genderToTest);
        spec.setGenders(genders);

        List<RandomUser> randomUsers = Generator.generateRandomUsers(spec, numberOfUsersToGenerate);
        assert randomUsers.size() == numberOfUsersToGenerate;

        for (RandomUser user : randomUsers) {
            assertUser(user);
            assert user.getGender().equals(genderToTest);
        }
    }

    @Test
    public void oneNationalitySpecTest() {
        int numberOfUsersToGenerate = 100;
        Nationality nationalityToTest = new Nationality.Australian();
        RandomUser.RandomUserSpec spec = new RandomUser.RandomUserSpec();
        List<Nationality> nationalities = new ArrayList<>();
        nationalities.add(nationalityToTest);
        spec.setNationalities(nationalities);

        List<RandomUser> randomUsers = Generator.generateRandomUsers(spec, numberOfUsersToGenerate);
        assert randomUsers.size() == numberOfUsersToGenerate;

        for (RandomUser user : randomUsers) {
            assertUser(user);
            assert user.getNationality().equals(nationalityToTest);
        }
    }

    @Test
    public void multipleNationalitiesSpecTest() {
        int numberOfUsersToGenerate = 100;
        RandomUser.RandomUserSpec spec = new RandomUser.RandomUserSpec();
        List<Nationality> nationalities = new ArrayList<>();
        nationalities.add(new Nationality.Australian());
        nationalities.add(new Nationality.German());
        nationalities.add(new Nationality.French());
        nationalities.add(new Nationality.Finnish());
        spec.setNationalities(nationalities);

        List<RandomUser> randomUsers = Generator.generateRandomUsers(spec, numberOfUsersToGenerate);
        assert randomUsers.size() == numberOfUsersToGenerate;

        for (RandomUser user : randomUsers) {
            assertUser(user);
            assert nationalities.contains(user.getNationality());
        }
    }

    @Test
    public void userSeedTest() {
        int numberOfUsersToGenerate = 100;
        long seed = 345676543;

        RandomUser.RandomUserSpec spec = new RandomUser.RandomUserSpec();
        spec.setSeed(seed);
        List<RandomUser> randomUsers = Generator.generateRandomUsers(spec, numberOfUsersToGenerate);

        Random.setSeed(seed);
        List<RandomUser> randomUsers2 = Generator.generateRandomUsers(spec, numberOfUsersToGenerate);

        for (int i = 0; i < numberOfUsersToGenerate; i++) {
            assertUser(randomUsers.get(i));
            assertUser(randomUsers2.get(i));
            if (!randomUsers.get(i).equals(randomUsers2.get(i))) {
                System.out.println("Stopping...");
            }
            assert randomUsers.get(i).equals(randomUsers2.get(i));
        }
    }

    private void assertUser(RandomUser randomUser) {
        System.out.println(randomUser.toString());
        System.out.println(randomUser.getNationality());

        assert randomUser.getName() != null;
        assert randomUser.getName().getTitle() != null;
        assert randomUser.getName().getFirstName() != null;
        assert randomUser.getName().getLastName() != null;

        assert (randomUser.getGender() == Gender.male || randomUser.getGender() == Gender.female);

        assert randomUser.getCell() != null;
        assert randomUser.getPhone() != null;
        assert randomUser.getDateOfBirth() != null;
        assert randomUser.getEmail().equals(randomUser.getName().getFirstName() + "." + randomUser.getName().getLastName().replaceAll(" ", "") + "@example.com");

        assert randomUser.getLocation() != null;
        assert randomUser.getLocation().getStreet() != null;
        assert randomUser.getLocation().getCity() != null;
        assert randomUser.getLocation().getPostCode() != null;
        assert randomUser.getLocation().getState() != null;

        assert randomUser.getLogin() != null;
        assert randomUser.getLogin().getSalt().length() == 8;
        assert randomUser.getLogin().getMD5() != null;
        assert randomUser.getLogin().getPassword() != null;
        assert randomUser.getLogin().getSHA1() != null;
        assert randomUser.getLogin().getSHA256() != null;
        assert randomUser.getLogin().getUsername() != null;

        assert randomUser.getNationality() != null;
        // assert randomUser.getPicture()!=null;
        assert randomUser.getRegistrationDate() != null;
    }
}
