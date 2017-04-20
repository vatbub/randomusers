package com.github.vatbub.randomusers.result;

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
    private String username;
    private String password;

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

    public String getSalt() {
        return Random.random(Random.RandomMode.lowerUpperNumbers, 8);
    }

    private HashCode getHashCode(Hasher hasher) {
        HashFunction hashFunction = Hashing.md5();
        return hasher.putString(getPassword() + getSalt(), Charsets.UTF_8).hash();
    }

    public String getMD5() {
        return getHashCode(Hashing.md5().newHasher()).toString();
    }

    public String getSHA1() {
        return getHashCode(Hashing.sha1().newHasher()).toString();
    }

    public String getSHA256() {
        return getHashCode(Hashing.sha256().newHasher()).toString();
    }
}
