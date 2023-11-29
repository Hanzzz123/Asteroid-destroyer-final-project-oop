package com.mygdx.game.screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.towerDefenceGame;

public class MainMenuScreen implements Screen {

    private static final int BUTTON_WIDTH = 380;
    private static final int BUTTON_HEIGHT = 100;

    private final towerDefenceGame game;
    private final Stage stage;


    public MainMenuScreen(towerDefenceGame game) {
        this.game = game;
        this.stage = new Stage(new ScreenViewport());
        setupUI();

    }

    private void setupUI() {
        final Table table = new Table();
        table.setFillParent(true);
        
        table.center().top();

        //active
        final TextButton newGameButton = new TextButton("", game.skin, "newGameButtonActive");
        TextButton loadGameButton = new TextButton("", game.skin, "loadGameButtonActive");
        TextButton settingsButton = new TextButton("", game.skin, "settingsButtonActive");
        final TextButton exitButton = new TextButton("", game.skin, "exitButtonActive");
        TextButton titleButton = new TextButton("", game.skin, "titleButtonActive");
        
        table.add(titleButton).width(600f).height(150f).padTop(50f).row(); // Adjust width, height, and padding as needed
        table.add(newGameButton).width(BUTTON_WIDTH).height(BUTTON_HEIGHT).padBottom(20).row();
        table.add(loadGameButton).width(BUTTON_WIDTH).height(BUTTON_HEIGHT).padBottom(20).row();
        table.add(settingsButton).width(BUTTON_WIDTH).height(BUTTON_HEIGHT).padBottom(20).row();
        table.add(exitButton).width(BUTTON_WIDTH).height(BUTTON_HEIGHT).padBottom(20).row();

        stage.addActor(table);

        newGameButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.changeScreen(towerDefenceGame.NEWGAME);
            }
        });

        loadGameButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Handle Load Game button click
            }
        });

        settingsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.changeScreen(towerDefenceGame.SETTINGSSCREEN);
            }
        });

        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Handle Exit button click
                Gdx.app.exit(); // For desktop applications
            }
        });
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        //Gdx.input.setInputProcessor(null);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 60f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    // Other methods...

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
        stage.dispose();
    }
}
