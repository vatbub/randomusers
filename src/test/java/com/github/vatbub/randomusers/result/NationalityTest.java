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


import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

/**
 * Tests for the {@link Nationality} class
 */
public class NationalityTest {
    @Test
    public void defaultLocaleTest() {
        Locale originalCurrentLocale = Locale.getDefault();

        for (Locale locale : Locale.getAvailableLocales()) {
            Locale.setDefault(locale);
            assertNationality(Nationality.getFromCurrentDefaultLocale(), locale);
        }
    }

    @Test
    public void availableNationalitiesCountTest() {
        Assert.assertEquals(16, Nationality.availableNationalities().size());
    }

    @Test
    public void availableNationalitiesCountTest2() {
        Assert.assertEquals(17, Nationality.availableNationalities2().size());
    }

    private void assertNationality(Nationality nationality, Locale locale) {
        Assert.assertNotNull(nationality);

        if (locale.equals(Locale.ENGLISH) || locale.equals(Locale.UK)) {
            Assert.assertEquals(new Nationality.British(), nationality);
        } else if (locale.equals(Locale.CANADA) || locale.equals(Locale.CANADA_FRENCH)) {
            Assert.assertEquals(new Nationality.Canadian(), nationality);
        } else if (locale.equals(Locale.FRANCE) || locale.equals(Locale.FRENCH)) {
            Assert.assertEquals(new Nationality.French(), nationality);
        } else if (locale.equals(Locale.GERMAN) || locale.equals(Locale.GERMANY)) {
            Assert.assertEquals(new Nationality.German(), nationality);
        } else if (locale.equals(Locale.US)) {
            Assert.assertEquals(new Nationality.American(), nationality);
        } else {
            Assert.assertEquals(new Nationality.American(), nationality);
        }
    }
}
