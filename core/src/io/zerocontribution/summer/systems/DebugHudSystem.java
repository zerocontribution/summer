package io.zerocontribution.summer.systems;

import com.artemis.systems.VoidEntitySystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.google.inject.Inject;

import java.text.NumberFormat;

public class DebugHudSystem extends VoidEntitySystem {

    SpriteBatch spriteBatch;

    BitmapFont font;

    @Override
    protected void initialize() {
        spriteBatch = new SpriteBatch();

        font = new BitmapFont();
        font.setUseIntegerPositions(false);
    }

    @Override
    protected void begin() {
        spriteBatch.begin();
    }

    @Override
    protected void processSystem() {
        String[] lines = new String[3];
        lines[0] = "FPS: " + Gdx.graphics.getFramesPerSecond();
        lines[1] = "Entities: active: " + world.getEntityManager().getActiveEntityCount() +
                "; created: " + world.getEntityManager().getTotalCreated() +
                "; deleted: " + world.getEntityManager().getTotalDeleted();

        NumberFormat format = NumberFormat.getInstance();
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;
        long freeMemory = Runtime.getRuntime().freeMemory() / 1024 / 1024;
        long allocatedMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;

        lines[2] = "Mem: free:" + format.format(freeMemory) + "; max:" + format.format(maxMemory) + "; allocated: " + format.format(allocatedMemory);

        for (int i = 0; i < lines.length; i++) {
            font.draw(spriteBatch, lines[i], 20, 20 + (i * 20));
        }
    }

    @Override
    protected void end() {
        spriteBatch.end();
    }
}
