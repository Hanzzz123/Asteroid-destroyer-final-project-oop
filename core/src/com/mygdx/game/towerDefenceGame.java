package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screens.MainMenuScreen;

public class towerDefenceGame extends Game {
	public static final int WIDTH = 1440;
	public static final int HEIGHT = 720;
	public SpriteBatch batch;

	@Override
	public void create() {
		batch = new SpriteBatch();
		this.setScreen(new MainMenuScreen(this));
	}

	public void render() {
		super.render();
	}
}