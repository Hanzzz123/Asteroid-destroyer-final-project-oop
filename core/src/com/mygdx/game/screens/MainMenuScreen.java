package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mygdx.game.towerDefenceGame;

public class MainMenuScreen implements Screen {

    private static final int NEW_GAME_BUTTON_WIDTH= 380;
    private static final int NEW_GAME_BUTTON_HEIGHT = 177;

    private static final int LOAD_GAME_BUTTON_WIDTH= 410;
    private static final int LOAD_GAME_BUTTON_HEIGHT = 171;

    private static final int SETTINGS_BUTTON_WIDTH= 309;
    private static final int SETTINGS_BUTTON_HEIGHT = 158;

    private static final int EXIT_BUTTON_WIDTH= 330;
    private static final int EXIT_BUTTON_HEIGHT = 222;

    private static final int NEW_GAME_BUTTON_Y = 240;
    private static final int LOAD_GAME_BUTTON_Y = 180;
    private static final int SETTINGS_GAME_BUTTON_Y = 120;
    private static final int EXIT_GAME_BUTTON_Y = 10;
    towerDefenceGame game;

    Texture newGameButtonActive;
    Texture newGameButtonInactive;
    Texture loadGameButtonActive;
    Texture loadGameButtonInactive;
    Texture settingsButtonActive;
    Texture settingButtonInactive;
    Texture exitButtonActive;
    Texture exitButtonInactive;

    Table table;
    public MainMenuScreen(towerDefenceGame game){
        this.game = game;
        newGameButtonActive = new Texture("newGameButtonActive.png");
        loadGameButtonActive = new Texture("loadGameButtonActive.png");
        settingsButtonActive = new Texture("settingsButtonActive.png");
        exitButtonActive = new Texture("exitButtonActive.png");

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();


        int x = towerDefenceGame.WIDTH / 2 - NEW_GAME_BUTTON_WIDTH /2;
        game.batch.draw(newGameButtonActive,x, NEW_GAME_BUTTON_Y, EXIT_BUTTON_WIDTH,EXIT_BUTTON_HEIGHT);

        x = towerDefenceGame.WIDTH / 2 - LOAD_GAME_BUTTON_WIDTH /2;
        game.batch.draw(loadGameButtonActive,x, LOAD_GAME_BUTTON_Y,LOAD_GAME_BUTTON_WIDTH,LOAD_GAME_BUTTON_HEIGHT);

        x = towerDefenceGame.WIDTH / 2 - SETTINGS_BUTTON_WIDTH / 2;
        game.batch.draw(settingsButtonActive,x, SETTINGS_GAME_BUTTON_Y,SETTINGS_BUTTON_WIDTH,SETTINGS_BUTTON_HEIGHT);

        x = towerDefenceGame.WIDTH / 2 - EXIT_BUTTON_WIDTH / 2;
        game.batch.draw(exitButtonActive,x,EXIT_GAME_BUTTON_Y,EXIT_BUTTON_WIDTH,EXIT_BUTTON_HEIGHT);

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