package io.zerocontribution.summer.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import io.zerocontribution.summer.combat.CombatProcessor;
import io.zerocontribution.summer.components.Action;

public class ActionProcessingSystem extends EntityProcessingSystem {
    @Mapper
    ComponentMapper<Action> actionComponentMapper;

    @SuppressWarnings("unchecked")
    public ActionProcessingSystem() {
        super(Aspect.getAspectForAll(Action.class));
    }

    @Override
    protected void process(Entity e) {
        CombatProcessor processor = actionComponentMapper.get(e).combatProcessor;
        if (processor != null) {
            processor.initialize(world);
            processor.process(e);
        }
    }
}
