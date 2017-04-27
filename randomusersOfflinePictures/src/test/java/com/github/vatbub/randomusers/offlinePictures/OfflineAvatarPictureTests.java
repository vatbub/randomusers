package com.github.vatbub.randomusers.offlinePictures;

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


import com.github.vatbub.randomusers.Generator;
import com.github.vatbub.randomusers.result.OfflineAvatarPicture;
import com.github.vatbub.randomusers.result.RandomUser;
import org.junit.Test;

/**
 * Tests the offline image functionality
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
