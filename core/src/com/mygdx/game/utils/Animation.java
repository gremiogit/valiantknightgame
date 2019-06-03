package com.mygdx.game.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Animation {
    private Array<TextureRegion> frames;
    private float maxFrameTime;
    private float currentFrameTime;
    private int frameCount;
    private int frame;

    public Animation(Texture texture, int frameCount, float frameDuration){
        frames = new Array<TextureRegion>();
        int frameWidth = texture.getWidth() / frameCount;
        for(int i = 0; i < frameCount; i++){
            frames.add(new TextureRegion(texture, i * frameWidth, 0, frameWidth, texture.getHeight()));
        }
        maxFrameTime = frameDuration / frameCount;
        this.frameCount = frameCount;
        frame = 0;
    }

    public void update(float dt){
        currentFrameTime += dt;
        if(currentFrameTime > maxFrameTime){
            frame++;
            currentFrameTime = 0;
        }
        if(frame >= frameCount){
            frame = 0;
        }
    }

    public TextureRegion getFrame(){
        return frames.get(frame);
    }

}
