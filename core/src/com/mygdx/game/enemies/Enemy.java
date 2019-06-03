package com.mygdx.game.enemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Hero;
import com.mygdx.game.utils.Tool;

import java.util.Random;

public class Enemy {
    private int currentHp, maxHp, level, atkDamage;
    private String name;
    private Animation<TextureRegion> idleAnimation, atkAnimation;
    private Random rand;

    public Enemy(String name, int maxHp, int level, Texture idleSheet, int idleFrameCount, Texture atkSheet, int atkFrameCount, float cycleTime){
        rand = new Random();
        this.name = name;
        this.maxHp = maxHp;
        currentHp = maxHp;
        this.level = level;
        atkDamage = rand.nextInt((10 - 3 + 1) + 3) * level;

        idleAnimation = new Animation<TextureRegion>(cycleTime, Tool.slice(idleSheet, idleFrameCount));
        atkAnimation = new Animation<TextureRegion>(cycleTime, Tool.slice(atkSheet, atkFrameCount));

    }

    public void attack(Hero hero){
        hero.setCurrentHp(-atkDamage);
    }

    public String getName() {
        return name;
    }

    public Animation<TextureRegion> getIdleAnimation() {
        return idleAnimation;
    }

    public Animation<TextureRegion> getAtkAnimation() {
        return atkAnimation;
    }
}
