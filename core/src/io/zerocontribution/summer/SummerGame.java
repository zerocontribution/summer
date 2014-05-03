package io.zerocontribution.summer;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class SummerGame extends ApplicationAdapter {
    Injector injector;
	SpriteBatch batch;
    Texture img;
	
	@Override
	public void create () {
        injector = Guice.createInjector(new SummerModule());
        batch = injector.getInstance(SpriteBatch.class);
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
}
