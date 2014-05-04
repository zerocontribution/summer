package io.zerocontribution.summer.combat;

import com.artemis.Entity;
import com.artemis.World;

// TODO Need to create a CombatProcessorPool
public interface CombatProcessor {
    public void initialize(World world);
    public void process(Entity ability);
}
