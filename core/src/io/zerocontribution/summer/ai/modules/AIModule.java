package io.zerocontribution.summer.ai.modules;

import com.artemis.Entity;

public interface AIModule {
    public void initialize();
    public boolean process(Entity e);
    public boolean shouldProcess(int acc);
}