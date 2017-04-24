package com.github.vatbub.randomusers.result;

import com.github.vatbub.randomusers.Generator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frederik on 24/04/2017.
 */
public class LoginTest {
    @Test
    public void saltTest() {
        Login login = new Login();

        assert login.getSalt().length() == 8;
    }

    @Test
    public void passwordSpecTest() {
        Generator.PasswordSpec passwordSpec = new Generator.PasswordSpec();
        passwordSpec.setMinLength(49);
        passwordSpec.setMaxLength(51);

        try {
            // should throw an exception
            passwordSpec.getExactLength();
            assert false;
        } catch (IllegalStateException e) {
            assert true;
        }

        passwordSpec.setExactLength(50);

        assert passwordSpec.getExactLength() == 50;
        assert passwordSpec.getMaxLength() == 50;
        assert passwordSpec.getMinLength() == 50;

        List<Generator.PasswordSpec.PasswordCharset> charsets = new ArrayList<>();
        charsets.add(Generator.PasswordSpec.PasswordCharset.special);
        charsets.add(Generator.PasswordSpec.PasswordCharset.upper);
        passwordSpec.setCharsets(charsets);

        Login res = Login.generateLogin(passwordSpec);
        assert res.getPassword().length() == 50;

        for (char chr : res.getPassword().toCharArray()) {
            assert Generator.PasswordSpec.PasswordCharset.getAvailableChars(charsets).contains(String.valueOf(chr));
        }

        charsets.add(Generator.PasswordSpec.PasswordCharset.lower);
        charsets.add(Generator.PasswordSpec.PasswordCharset.number);

        res = Login.generateLogin(passwordSpec);
        assert res.getPassword().length() == 50;

        for (char chr : res.getPassword().toCharArray()) {
            assert Generator.PasswordSpec.PasswordCharset.getAvailableChars(charsets).contains(String.valueOf(chr));
        }
    }
}
