package io.zerocontribution.summer.ai.modules;

import com.artemis.World;

public abstract class AbstractAIModule implements AIModule {
    public World world;

    public AbstractAIModule(World world) {
        this.world = world;
    }

    public void initialize() {}

    public boolean shouldProcess(int acc) {
        return true;
    }
}
