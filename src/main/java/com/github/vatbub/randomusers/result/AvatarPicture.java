package com.github.vatbub.randomusers.result;

import javafx.scene.image.Image;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Avatar pictures of {@link RandomUser}s
 */
@SuppressWarnings("unused")
public class AvatarPicture {
    // TODO: Implement the image generation
    @SuppressWarnings("FieldCanBeLocal")
    private int imageID;

    public AvatarPicture(int imageID){
        this.imageID = imageID;
    }

    public Image getLargePicture(){
        throw new NotImplementedException();
    }

    public Image getMediumPicture(){
        throw new NotImplementedException();
    }

    public Image getThumbnailPicture(){
        throw new NotImplementedException();
    }
}
