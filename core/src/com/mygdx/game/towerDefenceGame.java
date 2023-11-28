package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mygdx.game.screens.LoadGameScreen;
import com.mygdx.game.screens.MainGameScreen;
import com.mygdx.game.screens.MainMenuScreen;
import com.mygdx.game.screens.SettingsScreen;

public class towerDefenceGame extends Game {
    public static final int WIDTH = 1440;
    public static final int HEIGHT = 720;
    public SpriteBatch batch;
    public Skin skin;

    private MainMenuScreen mainMenuScreen;
    private MainGameScreen newGameScreen;
    private LoadGameScreen loadGameScreen;
    private  SettingsScreen settingsScreen;
    public final static int MAINMENUSCREEN = 0;
    public final static int NEWGAME = 1;
    public final static int LOADGAME = 2;
    public final static int SETTINGSSCREEN = 3;



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

        skin.add("newGameHovered",new Texture("newGamehovered.png"));
        skin.add("loadGameHovered",new Texture("loadGamehovered.png"));
        skin.add("settingsHovered",new Texture("settingsHovered.png"));
        skin.add("exitHovered",new Texture("exitHovered.png"));

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
        newGameButtonStyle.down = skin.getDrawable("newGameButtonActive");
        newGameButtonStyle.checked = skin.getDrawable("newGameButtonActive");
        newGameButtonStyle.over = skin.getDrawable("newGameHovered");
        newGameButtonStyle.font = skin.getFont("default-font");

        // Register the TextButtonStyle for newGameButtonActive
        skin.add("newGameButtonActive", newGameButtonStyle);

        // Create a TextButton style for loadGameButtonActive
        TextButton.TextButtonStyle loadGameButtonStyle = new TextButton.TextButtonStyle();
        loadGameButtonStyle.up = skin.getDrawable("loadGameButtonActive");
        loadGameButtonStyle.down = skin.getDrawable("loadGameButtonActive");
        loadGameButtonStyle.checked = skin.getDrawable("loadGameButtonActive");
        loadGameButtonStyle.over = skin.getDrawable("loadGameHovered");
        loadGameButtonStyle.font = skin.getFont("default-font");

        // Register the TextButtonStyle for loadGameButtonActive
        skin.add("loadGameButtonActive", loadGameButtonStyle);

        // Create a TextButton style for settingsButtonActive
        TextButton.TextButtonStyle settingsButtonStyle = new TextButton.TextButtonStyle();
        settingsButtonStyle.up = skin.getDrawable("settingsButtonActive");
        settingsButtonStyle.down = skin.getDrawable("settingsButtonActive");
        settingsButtonStyle.checked = skin.getDrawable("settingsButtonActive");
        settingsButtonStyle.over = skin.getDrawable("settingsHovered");
        settingsButtonStyle.font = skin.getFont("default-font");

        // Register the TextButtonStyle for settingsButtonActive
        skin.add("settingsButtonActive", settingsButtonStyle);

        // Create a TextButton style for exitButtonActive
        TextButton.TextButtonStyle exitButtonStyle = new TextButton.TextButtonStyle();
        exitButtonStyle.up = skin.getDrawable("exitButtonActive");
        exitButtonStyle.down = skin.getDrawable("exitButtonActive");
        exitButtonStyle.checked = skin.getDrawable("exitButtonActive");
        exitButtonStyle.over = skin.getDrawable("exitHovered");
        exitButtonStyle.font = skin.getFont("default-font");

        // Register the TextButtonStyle for exitButtonActive
        skin.add("exitButtonActive", exitButtonStyle);

        mainMenuScreen = new MainMenuScreen(this);
        setScreen(mainMenuScreen);
        //this.setScreen(new MainMenuScreen(this));
    }

    public void render() {
        super.render();
    }


    public void changeScreen(int screen) {
        switch (screen) {
            case MAINMENUSCREEN:
                if (mainMenuScreen == null) {
                    mainMenuScreen = new MainMenuScreen(this);
                }
                setScreen(mainMenuScreen);
                break;
            case NEWGAME:
                if (newGameScreen == null) {
                    newGameScreen = new MainGameScreen(this);
                }
                mainMenuScreen.dispose();
                setScreen(newGameScreen);
                break;
            case LOADGAME:
                if (loadGameScreen == null) {
                    loadGameScreen = new LoadGameScreen();
                }
                setScreen(loadGameScreen);
                break;
            case SETTINGSSCREEN:
                if (settingsScreen == null) {
                    settingsScreen = new SettingsScreen();
                }
                setScreen(settingsScreen);
                break;
        }
    }
}
