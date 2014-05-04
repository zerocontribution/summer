package io.zerocontribution.summer.abilities;

import com.artemis.Entity;
import com.artemis.World;
import io.zerocontribution.summer.combat.CombatProcessor;
import io.zerocontribution.summer.components.Position;

public abstract class Ability {
    public int id;

    abstract public Entity create(World world, Entity source, Position position);
    abstract public CombatProcessor getCombatProcessor();

}
