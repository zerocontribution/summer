package io.zerocontribution.summer.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import io.zerocontribution.summer.components.Expiring;

public class ExpiringSystem extends EntityProcessingSystem {
    @Mapper
    ComponentMapper<Expiring> expiringMapper;

    @SuppressWarnings("unchecked")
    public ExpiringSystem() {
        super(Aspect.getAspectForAll(Expiring.class));
    }

    @Override
    protected void process(Entity e) {
        Expiring expiring = expiringMapper.get(e);

        expiring.expiration -= world.delta;
        if (expiring.expiration <= 0) {
            e.deleteFromWorld();
        }
    }
}
