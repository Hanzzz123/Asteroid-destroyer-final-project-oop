package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.towerDefenceGame;

public class SettingsScreen implements Screen {

    @SuppressWarnings("unused")
	private towerDefenceGame game;
    private Stage stage;
    private Skin skin;
    private Table table;

    private Label titleLabel;
    private Label volumeMusicLabel;
    private Label volumeSoundLabel;
    private Label musicOnOffLabel;
    private Label soundOnOffLabel;

    private Slider volumeMusicSlider;
    private Slider volumeSoundSlider;

    private CheckBox musicCheckbox;
    private CheckBox soundEffectsCheckbox;

    private TextButton backButton;

    public SettingsScreen(final towerDefenceGame game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());
        skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        table = new Table();
        table.setFillParent(true);
        // Uncomment the line below to show debug lines
        //table.setDebug(true);


        // Initialize labels
        titleLabel = new Label("Settings", skin);
        volumeMusicLabel = new Label("Music Volume:", skin);
        volumeSoundLabel = new Label("Sound Volume:", skin);
        musicOnOffLabel = new Label("Music:", skin);
        soundOnOffLabel = new Label("Sound Effects:", skin);
        
     
        
     

        // Initialize sliders
        volumeMusicSlider = new Slider(0f, 1f, 0.1f, false, skin);
        volumeMusicSlider.setValue(game.getMusicVolume());

        volumeSoundSlider = new Slider(0f, 1f, 0.1f, false, skin);
        volumeSoundSlider.setValue(game.getSoundVolume());

        // Initialize checkboxes
        musicCheckbox = new CheckBox(null, skin);
        musicCheckbox.setChecked(game.isMusicEnabled());

        soundEffectsCheckbox = new CheckBox(null, skin);
        soundEffectsCheckbox.setChecked(game.isSoundEffectsEnabled());

        // Initialize back button
        backButton = new TextButton("Back", skin, "small");
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.changeScreen(towerDefenceGame.MAINMENUSCREEN);
            }
        });
        
        volumeMusicSlider.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setMusicVolume(volumeMusicSlider.getValue());
                game.updateMusicSettings();
            }
        });
        
        musicCheckbox.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setMusicEnabled(musicCheckbox.isChecked());
                game.updateMusicSettings();
            }
        });
        
        

        table.add(titleLabel).colspan(2).align(Align.center);
        table.row().pad(10, 0, 0, 0);
        table.add(volumeMusicLabel).left();
        table.add(volumeMusicSlider);
        table.row().pad(10, 0, 0, 0);
        table.add(musicOnOffLabel).left();
        table.add(musicCheckbox);
        table.row().pad(10, 0, 0, 0);
        table.add(volumeSoundLabel).left();
        table.add(volumeSoundSlider);
        table.row().pad(10, 0, 0, 0);
        table.add(soundOnOffLabel).left();
        table.add(soundEffectsCheckbox);
        table.row().pad(10, 0, 0, 0);
        table.add(backButton).colspan(2).align(Align.center);


        // Add table to stage
        stage.addActor(table);
    }
    
    

    @Override
    public void show() {
       Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        // Your render logic here
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {
        // Handle pause logic
    }

    @Override
    public void resume() {
        // Handle resume logic
    }

    @Override
    public void hide() {
        // Dispose of resources when the screen is hidden
    }

    @Override
    public void dispose() {
        // Dispose of resources when the screen is destroyed
        stage.dispose();
    }
}
