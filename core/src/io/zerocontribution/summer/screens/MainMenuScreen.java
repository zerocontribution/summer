package io.zerocontribution.summer.screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import io.zerocontribution.summer.services.ScreenService;

public class MainMenuScreen extends AbstractScreen {

    @Override
    public void show() {
        super.show();

        TextButton playButton = new TextButton("Play", skin);
        playButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                screenService.changeScreen(ScreenService.GAME);
                return true;
            }
        });

        Table table = new Table();
        table.setFillParent(true);
        table.add(playButton);

        stage.addActor(table);
    }
}
