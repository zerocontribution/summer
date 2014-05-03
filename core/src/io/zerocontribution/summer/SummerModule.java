package io.zerocontribution.summer;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.google.inject.AbstractModule;
import io.zerocontribution.summer.services.ScreenService;

public class SummerModule extends AbstractModule {
    Game game;

    public SummerModule(Game game) {
        this.game = game;
    }

    protected void configure() {
        bind(SpriteBatch.class).toInstance(new SpriteBatch());

        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        Gdx.input.setInputProcessor(inputMultiplexer);
        bind(InputMultiplexer.class).toInstance(inputMultiplexer);

        bind(Skin.class).toInstance(new Skin(Gdx.files.internal("ui/HoloSkin/Holo-dark-hdpi.json")));

        bind(ScreenService.class).toInstance(new ScreenService(game));
    }
}
