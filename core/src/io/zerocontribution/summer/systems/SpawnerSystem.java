package io.zerocontribution.summer.systems;

import com.artemis.systems.VoidEntitySystem;
import com.badlogic.gdx.utils.Array;
import io.zerocontribution.summer.spawners.EliteSpawner;
import io.zerocontribution.summer.spawners.Spawner;

/**
 * @todo Move spawner setup to assets file.
 */
public class SpawnerSystem extends VoidEntitySystem {

    Array<Spawner> spawners = new Array<Spawner>();

    public SpawnerSystem() {
        super();
        spawners.add(new EliteSpawner());
    }

    protected boolean checkProcessing() {
        return true;
    }

    protected void processSystem() {
        for (Spawner spawner : spawners) {
            if (spawner.shouldSpawn(world)) {
                spawner.spawn(world);
            }
        }
    }

}
