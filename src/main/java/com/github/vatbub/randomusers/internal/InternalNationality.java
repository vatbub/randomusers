package com.github.vatbub.randomusers.internal;

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


import com.github.vatbub.randomusers.result.Nationality;

import java.util.Locale;

/**
 * Internal class to implement a default {@code equals}-method for all {@link Nationality nationalities}
 */
public abstract class InternalNationality implements Nationality {

    /**
     * Converts the current default locale to a {@link Nationality}
     *
     * @return The {@link Nationality} that represents the current default Locale
     */
    @SuppressWarnings("unused")
    public static Nationality getFromCurrentDefaultLocale() {
        Locale currentLocale = Locale.getDefault();
        if (currentLocale.equals(Locale.ENGLISH) || currentLocale.equals(Locale.UK)) {
            return new Nationality.British();
        } else if (currentLocale.equals(Locale.CANADA) || currentLocale.equals(Locale.CANADA_FRENCH)) {
            return new Nationality.Canadian();
        } else if (currentLocale.equals(Locale.FRANCE) || currentLocale.equals(Locale.FRENCH)) {
            return new Nationality.French();
        } else if (currentLocale.equals(Locale.GERMAN) || currentLocale.equals(Locale.GERMANY)) {
            return new Nationality.German();
        } else if (currentLocale.equals(Locale.US)) {
            return new Nationality.American();
        } else {
            return new Nationality.American();
        }
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Nationality && ((Nationality) obj).getShortCode().equals(this.getShortCode());
    }
}
