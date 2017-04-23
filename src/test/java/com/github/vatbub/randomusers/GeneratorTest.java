package com.github.vatbub.randomusers;

import com.github.vatbub.randomusers.result.Gender;
import com.github.vatbub.randomusers.result.RandomUser;
import org.junit.Test;

/**
 * Main {@link Generator}-Tests
 */
public class GeneratorTest {
    @Test
    public void generateOneUser(){
        RandomUser randomUser = Generator.generateRandomUser(new RandomUser.RandomUserSpec());
        System.out.println(randomUser.toString());
        assert randomUser.getName()!=null;
        assert randomUser.getName().getTitle()!=null;
        assert randomUser.getName().getFirstName()!=null;
        assert randomUser.getName().getLastName()!=null;
        
        assert (randomUser.getGender()== Gender.male||randomUser.getGender()==Gender.female);
        
        assert randomUser.getCell()!=null;
        assert randomUser.getPhone()!=null;
        assert randomUser.getDateOfBirth()!=null;
        assert randomUser.getEmail().equals(randomUser.getName().getFirstName() + "." + randomUser.getName().getLastName().replaceAll(" ", "") + "@example.com");

        assert randomUser.getLocation()!=null;
        assert randomUser.getLocation().getStreet()!=null;
        assert randomUser.getLocation().getCity()!=null;
        assert randomUser.getLocation().getPostCode()!=null;
        assert randomUser.getLocation().getState()!=null;

        assert randomUser.getLogin()!=null;
        assert randomUser.getLogin().getSalt().length()==8;
        assert randomUser.getLogin().getMD5()!=null;
        assert randomUser.getLogin().getPassword()!=null;
        assert randomUser.getLogin().getSHA1()!=null;
        assert randomUser.getLogin().getSHA256()!=null;
        assert randomUser.getLogin().getUsername()!=null;

        assert randomUser.getNationality()!=null;
        // assert randomUser.getPicture()!=null;
        assert randomUser.getRegistrationDate()!=null;
    }
}
