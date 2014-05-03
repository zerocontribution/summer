package io.zerocontribution.summer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.google.inject.AbstractModule;

public class SummerModule extends AbstractModule {
    protected void configure() {
        bind(SpriteBatch.class).toInstance(new SpriteBatch());
    }
}
