package io.zerocontribution.summer.spawners;

import com.artemis.World;
import com.badlogic.gdx.utils.Array;

import java.util.Random;

public abstract class Spawner {

    public final static String MAP_SPAWN_LAYER = "Spawns";

    public Array<String> enemies;
    public String zone;

    abstract public void spawn(World world);

    public boolean shouldSpawn(World world) {
        return true;
    }

    protected String getGroupName() {
        return this.getClass().getSimpleName() + this.hashCode();
    }

}
