package com.github.vatbub.randomusers.result;

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
