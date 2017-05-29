package com.github.vatbub.randomusers.result;

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


import com.github.vatbub.randomusers.Generator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit tests for the {@link Login}-class
 */
public class LoginTest {
    @Test
    public void saltTest() {
        Login login = new Login();

        assert login.getSalt().length() == 8;
    }

    @Test
    public void hashTest() {
        Login login = Login.generateLogin();

        // check if we don't get a object reference instead of a hash code
        assert !login.getMD5().contains("@");
        assert !login.getSHA1().contains("@");
        assert !login.getSHA256().contains("@");
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
