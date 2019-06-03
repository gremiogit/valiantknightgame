package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.mygdx.game.Hero;
import com.mygdx.game.Project;
import com.mygdx.game.enemies.Enemy;

import java.util.ArrayList;

public class PlayScreen implements Screen {

    private Project proj;
    private Texture background;
    private Hero hero;
    private float stateTime;
    private ArrayList<Enemy> enemies;

    //HUD
    private Texture knightIcon;
    private BitmapFont font;
    private GlyphLayout levelLayout, hpLayout, mpLayout, xpLayout;


    public PlayScreen(Project proj){
        this.proj = proj;
        background = new Texture("download.jpg");
        knightIcon = new Texture("knight_icon.png");
        stateTime = 0;
        hero = new Hero();
        enemies = new ArrayList<Enemy>();
        enemies.add(new Enemy("Assassin", 100, 1, new Texture(Gdx.files.internal("assassin_idle.png")),6, new Texture(Gdx.files.internal("assassin_atk.png")), 13, .1f));
        font = new BitmapFont(Gdx.files.internal("font.fnt"));
        levelLayout = new GlyphLayout(font, "Lvl" + hero.getLevel());
        hpLayout = new GlyphLayout(font, "HP " + hero.getCurrentHp() + "/" + hero.getMaxHp());
        mpLayout = new GlyphLayout(font, "MP " + hero.getCurrentMp() + "/" + hero.getMaxMp());
        xpLayout = new GlyphLayout(font, "XP " + hero.getXp() + "/" + hero.getXpTnl());
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        stateTime += Gdx.graphics.getDeltaTime();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        proj.batch.begin();
        proj.batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        proj.batch.draw(knightIcon, 15, 700, knightIcon.getWidth() * 5, knightIcon.getHeight() * 5);
        font.draw(proj.batch, levelLayout, 5, 680);
        font.draw(proj.batch, hpLayout, 140, 780);
        font.draw(proj.batch, mpLayout, 140, 740);
        font.draw(proj.batch, xpLayout, 140, 700);
        proj.batch.draw(hero.getIdleAnimation().getKeyFrame(stateTime, true), 50, 100, 395, 315);
        //proj.batch.draw(enemies.get(0).getIdleAnimation().getKeyFrame(stateTime, true), 800, 90, 380, 270);
        if(Gdx.input.isTouched()) {
            proj.batch.draw(enemies.get(0).getAtkAnimation().getKeyFrame(stateTime, false), 760, 60, 380 * 1.5f, 270 * 1.5f);
        }else{
            proj.batch.draw(enemies.get(0).getIdleAnimation().getKeyFrame(stateTime, true), 800, 90, 380, 270);

        }
        proj.batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        background.dispose();
    }
}
