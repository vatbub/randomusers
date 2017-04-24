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

/**
 * Internal class to implement a default {@code equals}-method for all {@link Nationality nationalities}
 */
public abstract class InternalNationality implements Nationality {
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Nationality && ((Nationality) obj).getShortCode().equals(this.getShortCode());
    }
}
