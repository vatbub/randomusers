package com.github.vatbub.randomusers.internal;

import org.junit.Test;

/**
 * Tests for the {@link InternalNationality} class
 */
public class InternationalNationalityTest {
    @Test
    public void nationalityFromDefaultLocaleNotNullTest() {
        //noinspection ConstantConditions
        assert InternalNationality.getFromCurrentDefaultLocale() != null;
    }
}
