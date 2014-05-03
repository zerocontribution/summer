package io.zerocontribution.summer;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.google.inject.Guice;
import io.zerocontribution.summer.services.ScreenService;

public class SummerGame extends Game {
	@Override
	public void create () {
        AppInjector.setInjector(Guice.createInjector(new SummerModule(this)));
        AppInjector.injector.getInstance(ScreenService.class).changeScreen(ScreenService.MAIN_MENU);
    }

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        super.render();
	}
}
