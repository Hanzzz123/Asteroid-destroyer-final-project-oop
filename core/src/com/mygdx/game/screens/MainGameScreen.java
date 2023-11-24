package com.mygdx.game.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.towerDefenceGame;

public class MainGameScreen implements Screen {
    Texture img;
    float x;
    float y;

    towerDefenceGame game;
    public MainGameScreen(towerDefenceGame game){
        this.game = game;
    }

    @Override
    public void show() {
        img = new Texture("badlogic.jng");
    }

    @Override
    public void render(float delta) {
        game.batch.draw(img, x, y);
        game.batch.end();
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

    }
}