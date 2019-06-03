package com.mygdx.game.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Tool {

    public static Array<TextureRegion> slice(Texture texture, int frameCount){
        Array<TextureRegion> frames = new Array<TextureRegion>();
        int frameWidth = texture.getWidth() / frameCount;
        for(int i = 0; i < frameCount; i++){
            frames.add(new TextureRegion(texture, i * frameWidth, 0, frameWidth, texture.getHeight()));
        }
        return frames;

    }
}
