package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mygdx.game.screens.LoadGameScreen;
import com.mygdx.game.screens.MainGameScreen;
import com.mygdx.game.screens.MainMenuScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.mygdx.game.tools.GameCamera;
import com.mygdx.game.tools.ScrollingBackground;

public class SpaceGame extends Game {

    public static final int WIDTH = 480;
    public static final int HEIGHT = 720;
    public static boolean IS_MOBILE = false;

    public SpriteBatch batch;
    public ScrollingBackground scrollingBackground;
    public GameCamera cam;

    @Override
    public void create () {
        batch = new SpriteBatch();
        cam = new GameCamera(WIDTH, HEIGHT);

        this.scrollingBackground = new ScrollingBackground();
        this.setScreen(new MainMenuScreen(this));
    }

    @Override
    public void render () {
        batch.setProjectionMatrix(cam.combined());
        super.render();
    }

    @Override
    public void resize(int width, int height) {
        cam.update(width, height);
        super.resize(width, height);
    }

}