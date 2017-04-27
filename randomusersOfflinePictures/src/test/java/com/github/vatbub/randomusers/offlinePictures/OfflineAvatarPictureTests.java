package com.github.vatbub.randomusers.offlinePictures;

import com.github.vatbub.randomusers.Generator;
import com.github.vatbub.randomusers.result.OfflineAvatarPicture;
import com.github.vatbub.randomusers.result.RandomUser;
import org.junit.Test;

/**
 * Created by Frederik on 27/04/2017.
 */
public class OfflineAvatarPictureTests {
    @Test
    public void offlineImageTest() {
        RandomUser randomUser = Generator.generateRandomUser(new RandomUser.RandomUserSpec());
        OfflineAvatarPicture offlineAvatarPicture = OfflineAvatarPicture.fromAvatarPicture(randomUser.getPicture());
        assert offlineAvatarPicture.getLargePicture() != null;
        assert offlineAvatarPicture.getMediumPicture() != null;
        assert offlineAvatarPicture.getThumbnailPicture() != null;
    }
}
