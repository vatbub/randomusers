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


import java.net.URL;

/**
 * Represents a offline version of the class {@code AvatarPicture}
 */
@SuppressWarnings("unused")
public class OfflineAvatarPicture extends AvatarPicture {

    public OfflineAvatarPicture(int imageID, Gender gender) {
        super(imageID, gender);
    }

    public static OfflineAvatarPicture fromAvatarPicture(AvatarPicture avatarPicture) {
        return new OfflineAvatarPicture(avatarPicture.getImageID(), avatarPicture.getGender());
    }

    @Override
    public URL getLargePicture() {
        return OfflineAvatarPicture.class.getResource("images/" + largePrefix + getGender().getGenderText() + "/" + getImageID() + ".jpg");
    }

    @Override
    public URL getMediumPicture() {
        return OfflineAvatarPicture.class.getResource("images/" + mediumPrefix + getGender().getGenderText() + "/" + getImageID() + ".jpg");
    }

    @Override
    public URL getThumbnailPicture() {
        return OfflineAvatarPicture.class.getResource("images/" + thumbnailPrefix + getGender().getGenderText() + "/" + getImageID() + ".jpg");
    }
}
