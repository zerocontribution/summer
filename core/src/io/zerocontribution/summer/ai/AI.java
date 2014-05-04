package io.zerocontribution.summer.ai;

import com.artemis.Entity;
import com.artemis.World;
import io.zerocontribution.summer.ai.modules.AIModule;

public abstract class AI {
    public AIModule[] modules;

    final public String name = "AI";

    private final World world;

    private boolean initialized = false;
    private int acc = 0;

    public AI(World world) {
        this.world = world;
    }

    public void initialize() {
        if (!initialized) {
            for (int i = 0; i < modules.length; i++) {
                modules[i].initialize();
            }
            initialized = true;
        }
    }

    public void process(Entity e) {
        processModules(e);
    }

    protected void processModules(Entity e) {
        acc++;
        for (int i = 0; i < modules.length; i++) {
            if (modules[i].shouldProcess(acc) && modules[i].process(e)) break;
        }

        if (acc == Integer.MAX_VALUE) {
            acc = 0;
        }
    }
}
