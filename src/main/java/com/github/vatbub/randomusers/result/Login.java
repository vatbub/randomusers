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


import com.github.vatbub.randomusers.Generator.PasswordSpec;
import com.github.vatbub.randomusers.data.DataSet;
import com.github.vatbub.randomusers.internal.Random;
import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;

/**
 * Login credentials of a {@link RandomUser}
 */
@SuppressWarnings("unused")
public class Login {
    private final String salt = Random.random(Random.RandomMode.lowerUpperNumbers, 8);
    private String username;
    private String password;

    /**
     * Generates random login credentials
     *
     * @return A random {@link Login}
     * @see #generateLogin(PasswordSpec)
     */
    public static Login generateLogin() {
        Login res = new Login();
        res.setUsername(generateUsername());
        res.setPassword((String) Random.randomItem(DataSet.CommonDataSet.getPasswords().toArray()));
        return res;
    }

    private static String generateUsername() {
        return (String) Random.randomItem(DataSet.CommonDataSet.getUser1().toArray()) + Random.randomItem(DataSet.CommonDataSet.getUser2().toArray()) + Random.range(100, 999);
    }

    /**
     * Generates random login credentials that follow the specified {@link PasswordSpec PasswordSpecs}
     *
     * @param passwordSpec The {@link PasswordSpec PasswordSpecs} to use to generate the password
     * @return A random {@link Login} whose password follows the specified {@link PasswordSpec PasswordSpecs}
     * @see #generateLogin()
     */
    public static Login generateLogin(PasswordSpec passwordSpec) {
        Login res = new Login();
        res.setUsername(generateUsername());

        int length = Random.range(passwordSpec.getMinLength(), passwordSpec.getMaxLength());
        StringBuilder password = new StringBuilder();
        char[] array = PasswordSpec.PasswordCharset.getAvailableChars(passwordSpec.getCharsets()).toCharArray();
        while (password.length() < length) {
            password.append(array[Random.range(0, array.length - 1)]);
        }

        res.setPassword(password.toString());
        return res;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Login)) {
            return false;
        } else {
            Login cast = (Login) obj;
            return cast.getUsername().equals(getUsername()) &&
                    cast.getPassword().equals(getPassword()) &&
                    cast.getSalt().equals(getSalt());
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * A random {@code String} that is 8 characters long and
     *
     * @return
     */
    public String getSalt() {
        return salt;
    }

    private HashCode getHashCode(Hasher hasher) {
        HashFunction hashFunction = Hashing.md5();
        return hasher.putString(getPassword() + getSalt(), Charsets.UTF_8).hash();
    }

    /**
     * Calculates the MD5-Hash of the concatenation of the password and the salt.
     *
     * @return The MD5-Hash of the concatenation of the password and the salt.
     * @see #getSalt()
     * @see #getPassword()
     */
    public String getMD5() {
        return getHashCode(Hashing.md5().newHasher()).toString();
    }

    /**
     * Calculates the SHA1-Hash of the concatenation of the password and the salt.
     *
     * @return The SHA1-Hash of the concatenation of the password and the salt.
     * @see #getSalt()
     * @see #getPassword()
     */
    public String getSHA1() {
        return getHashCode(Hashing.sha1().newHasher()).toString();
    }

    /**
     * Calculates the SHA256-Hash of the concatenation of the password and the salt.
     *
     * @return The SHA256-Hash of the concatenation of the password and the salt.
     * @see #getSalt()
     * @see #getPassword()
     */
    public String getSHA256() {
        return getHashCode(Hashing.sha256().newHasher()).toString();
    }

    @Override
    public String toString() {
        return "username: " + getUsername() + ", password: " + getPassword() + ", salt: " + getSalt();
    }
}
