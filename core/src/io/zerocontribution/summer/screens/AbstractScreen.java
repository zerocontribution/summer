package io.zerocontribution.summer.screens;

import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.google.inject.Inject;
import io.zerocontribution.summer.services.ScreenService;

public class AbstractScreen implements Screen {

    Stage stage;

    @Inject
    Skin skin;

    @Inject
    InputMultiplexer inputMultiplexer;

    @Inject
    ScreenService screenService;

    public void render(float delta) {
        stage.act(delta);
        stage.draw();
        // TODO Add debug flag.
        Table.drawDebug(stage);
    }

    public void resize(int width, int height) {

    }

    public void show() {
        stage = new Stage();
        inputMultiplexer.addProcessor(stage);
    }

    public void hide() {
        inputMultiplexer.removeProcessor(stage);
    }

    public void pause() {

    }

    public void resume() {

    }

    public void dispose() {
        inputMultiplexer.removeProcessor(stage);
        stage.dispose();
    }
}
