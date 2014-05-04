package io.zerocontribution.summer.abilities;

import com.artemis.Entity;
import com.artemis.World;
import io.zerocontribution.summer.combat.CombatProcessor;
import io.zerocontribution.summer.combat.PunchProcessor;
import io.zerocontribution.summer.components.Expiring;
import io.zerocontribution.summer.components.Position;

public class PunchAbility extends Ability {
    @Override
    public Entity create(World world, Entity source, Position position) {
        Entity e = world.createEntity();
        e.addComponent(new Expiring(0.25f));
        e.addComponent(new Position(position.x, position.y));

        // TODO Add directions

        return e;
    }

    @Override
    public CombatProcessor getCombatProcessor() {
        return new PunchProcessor();
    }
}
