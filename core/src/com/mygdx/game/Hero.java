package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.utils.Tool;

public class Hero {

    private int currentHp, maxHp, currentMp, maxMp, level, xp, xpTnl;
    private Animation<TextureRegion> atkAnimation, idleAnimation;
    private static final float ANIMATION_SPEED = 0.1f;

    public Hero(){

        currentHp = 100;
        maxHp = 100;
        currentMp = 100;
        maxMp = 100;
        level = 1;
        xp = 0;
        xpTnl = 100;
        atkAnimation = new Animation<TextureRegion>(ANIMATION_SPEED, Tool.slice(new Texture("hero_attack.png"), 14));
        idleAnimation = new Animation<TextureRegion>(ANIMATION_SPEED, Tool.slice(new Texture("hero_idle.png"), 6));
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getCurrentMp() {
        return currentMp;
    }

    public void setCurrentMp(int currentMp) {
        this.currentMp = currentMp;
    }

    public int getMaxMp() {
        return maxMp;
    }

    public void setMaxMp(int maxMp) {
        this.maxMp = maxMp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getXpTnl(){
        return xpTnl;
    }

    public Animation<TextureRegion> getAtkAnimation() {
        return atkAnimation;
    }

    public Animation<TextureRegion> getIdleAnimation() {
        return idleAnimation;
    }
}
