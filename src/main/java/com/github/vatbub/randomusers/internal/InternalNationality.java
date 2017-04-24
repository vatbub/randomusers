package com.github.vatbub.randomusers.internal;

import com.github.vatbub.randomusers.result.Nationality;

/**
 * Internal class to implement a default {@code equals}-method for all {@link Nationality nationalities}
 */
public abstract class InternalNationality implements Nationality {
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Nationality && ((Nationality) obj).getShortCode().equals(this.getShortCode());
    }
}
