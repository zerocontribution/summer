package io.zerocontribution.summer.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.esotericsoftware.minlog.Log;
import com.google.inject.Inject;
import io.zerocontribution.summer.abilities.Ability;
import io.zerocontribution.summer.components.*;
import io.zerocontribution.summer.services.AbilityService;

public class ActionInputProcessingSystem extends EntityProcessingSystem {

    @Inject
    AbilityService abilityService;

    @Mapper
    ComponentMapper<ActionInput> actionInputMapper;

    @Mapper
    ComponentMapper<Condition> conditionMapper;

    @Mapper
    ComponentMapper<Actor> actorMapper;

    @Mapper
    ComponentMapper<Position> positionMapper;

    @SuppressWarnings("unchecked")
    public ActionInputProcessingSystem() {
        super(Aspect.getAspectForAll(Actor.class, ActionInput.class));
    }

    @Override
    protected void process(Entity e) {
        if (conditionMapper.get(e).state != Condition.State.DYING) {
            ActionInput action = actionInputMapper.get(e);
            Actor actor = actorMapper.get(e);

            if (actor.hasAbility(action.abilityId)) {
                if (!actor.isAbilityInCooldown(action.abilityId)) {
                    actor.resetAbilityCooldown(action.abilityId);

                    Log.info("ActionInput", "Executing action " + action.abilityId);
                    Ability ability = abilityService.get(action.abilityId);
                    Entity abilityEntity = ability.create(world, e, positionMapper.get(e));
                    abilityEntity.addComponent(new Action(e, action.target, ability.getCombatProcessor()));
                } else {
                    Log.info("ActionInput", "Action in cooldown: " + action.abilityId);
                }
            } else {
                Log.warn("ActionInput", "Actor does not have ability: " + action.abilityId);
            }
        } else {
            Log.info("ActionInput", "Actor is dead, cancelling action");
        }

        e.removeComponent(ActionInput.class);
        e.changedInWorld();
    }
}
