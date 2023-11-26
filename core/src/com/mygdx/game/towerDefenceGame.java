package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mygdx.game.screens.MainMenuScreen;

public class towerDefenceGame extends Game {
    public static final int WIDTH = 1440;
    public static final int HEIGHT = 720;
    public SpriteBatch batch;
    public Skin skin;

    @Override
    public void create() {
        batch = new SpriteBatch();
        skin = new Skin(); // Create a default skin

        // Add your button textures to the skin
        skin.add("newGameButtonActive", new Texture("newGameButtonActive.png"));
        skin.add("loadGameButtonActive", new Texture("loadGameButtonActive.png"));
        skin.add("settingsButtonActive", new Texture("settingsButtonActive.png"));
        skin.add("exitButtonActive", new Texture("exitButtonActive.png"));
        skin.add("titleButtonActive", new Texture("titleButtonActive.png"));
        // Create a default BitmapFont
        BitmapFont font = new BitmapFont();
        skin.add("default-font", font);
        
        TextButton.TextButtonStyle titleButtonStyle = new TextButton.TextButtonStyle();
        titleButtonStyle.up = skin.getDrawable("titleButtonActive");
        titleButtonStyle.down = skin.getDrawable("titleButtonActive");
        titleButtonStyle.checked = skin.getDrawable("titleButtonActive");
        titleButtonStyle.over = skin.getDrawable("titleButtonActive");
        titleButtonStyle.font = skin.getFont("default-font");
        titleButtonStyle.up.setMinWidth(600f);  // Adjust as needed
        titleButtonStyle.up.setMinHeight(150f); // Adjust as needed
        skin.add("titleButtonActive", titleButtonStyle);

        // Create a TextButton style for newGameButtonActive
        TextButton.TextButtonStyle newGameButtonStyle = new TextButton.TextButtonStyle();
        newGameButtonStyle.up = skin.getDrawable("newGameButtonActive");
        newGameButtonStyle.down = skin.getDrawable("loadGameButtonActive");
        newGameButtonStyle.checked = skin.getDrawable("settingsButtonActive");
        newGameButtonStyle.over = skin.getDrawable("exitButtonActive");
        newGameButtonStyle.font = skin.getFont("default-font");

        // Register the TextButtonStyle for newGameButtonActive
        skin.add("newGameButtonActive", newGameButtonStyle);

        // Create a TextButton style for loadGameButtonActive
        TextButton.TextButtonStyle loadGameButtonStyle = new TextButton.TextButtonStyle();
        loadGameButtonStyle.up = skin.getDrawable("loadGameButtonActive");
        loadGameButtonStyle.down = skin.getDrawable("loadGameButtonActive");
        loadGameButtonStyle.checked = skin.getDrawable("loadGameButtonActive");
        loadGameButtonStyle.over = skin.getDrawable("loadGameButtonActive");
        loadGameButtonStyle.font = skin.getFont("default-font");

        // Register the TextButtonStyle for loadGameButtonActive
        skin.add("loadGameButtonActive", loadGameButtonStyle);

        // Create a TextButton style for settingsButtonActive
        TextButton.TextButtonStyle settingsButtonStyle = new TextButton.TextButtonStyle();
        settingsButtonStyle.up = skin.getDrawable("settingsButtonActive");
        settingsButtonStyle.down = skin.getDrawable("settingsButtonActive");
        settingsButtonStyle.checked = skin.getDrawable("settingsButtonActive");
        settingsButtonStyle.over = skin.getDrawable("settingsButtonActive");
        settingsButtonStyle.font = skin.getFont("default-font");

        // Register the TextButtonStyle for settingsButtonActive
        skin.add("settingsButtonActive", settingsButtonStyle);

        // Create a TextButton style for exitButtonActive
        TextButton.TextButtonStyle exitButtonStyle = new TextButton.TextButtonStyle();
        exitButtonStyle.up = skin.getDrawable("exitButtonActive");
        exitButtonStyle.down = skin.getDrawable("exitButtonActive");
        exitButtonStyle.checked = skin.getDrawable("exitButtonActive");
        exitButtonStyle.over = skin.getDrawable("exitButtonActive");
        exitButtonStyle.font = skin.getFont("default-font");

        // Register the TextButtonStyle for exitButtonActive
        skin.add("exitButtonActive", exitButtonStyle);

        this.setScreen(new MainMenuScreen(this));
    }

    public void render() {
        super.render();
    }
}
