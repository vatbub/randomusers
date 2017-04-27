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


import java.net.MalformedURLException;
import java.net.URL;

/**
 * Avatar pictures of {@link RandomUser}s.
 * The methods will return a URL where you can download the profile image from.
 * Images are served from <a href="https://randomuser.me/">randomuser.me</a>.
 * Please read their <a href="https://randomuser.me/copyright">Copyright Notice</a> to learn how you may use the pictures.
 */
@SuppressWarnings("unused")
public class AvatarPicture {
    static final String largePrefix = "";
    static final String mediumPrefix = "med/";
    static final String thumbnailPrefix = "thumb/";
    private static final String baseURL = "https://randomuser.me/api/portraits/";
    private int imageID;
    private Gender gender;

    public AvatarPicture(int imageID, Gender gender) {
        setImageID(imageID);
        setGender(gender);
    }


    @Override
    public boolean equals(Object obj) {
        return obj instanceof AvatarPicture && ((AvatarPicture) obj).getImageID() == this.getImageID() && ((AvatarPicture) obj).getGender() == this.getGender();
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public URL getLargePicture() throws MalformedURLException {
        return new URL(baseURL + largePrefix + getGender().getGenderText() + "/" + getImageID() + ".jpg");
    }

    public URL getMediumPicture() throws MalformedURLException {
        return new URL(baseURL + mediumPrefix + getGender().getGenderText() + "/" + getImageID() + ".jpg");
    }

    public URL getThumbnailPicture() throws MalformedURLException {
        return new URL(baseURL + thumbnailPrefix + getGender().getGenderText() + "/" + getImageID() + ".jpg");
    }
}
