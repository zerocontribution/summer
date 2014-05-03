package io.zerocontribution.summer.services;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ArrayMap;
import io.zerocontribution.summer.AppInjector;
import io.zerocontribution.summer.screens.GameScreen;
import io.zerocontribution.summer.screens.MainMenuScreen;

public class ScreenService {

    public static final String MAIN_MENU = "mainMenu";
    public static final String GAME = "game";

    Game game;
    ArrayMap<String, Screen> screens;

    private boolean initialized = false;

    public ScreenService(Game game) {
        this.game = game;
    }

    private void initialize() {
        initialized = true;

        screens = new ArrayMap<String, Screen>();
        screens.put(MAIN_MENU, AppInjector.injector.getInstance(MainMenuScreen.class));
        screens.put(GAME, AppInjector.injector.getInstance(GameScreen.class));
    }

    public void changeScreen(String name) {
        if (!initialized) {
            initialize();
        }
        game.setScreen(screens.get(name));
    }
}
