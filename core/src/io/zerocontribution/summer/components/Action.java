package io.zerocontribution.summer.components;

import com.artemis.Component;
import com.artemis.Entity;
import io.zerocontribution.summer.combat.CombatProcessor;

public class Action extends Component {
    public Entity source;
    public Entity target;
    public CombatProcessor combatProcessor;

    public Action(Entity source) {
        this.source = source;
    }

    public Action(Entity source, Entity target) {
        this(source);
        this.target = target;
    }

    public Action(Entity source, Entity target, CombatProcessor combatProcessor) {
        this(source, target);
        this.combatProcessor = combatProcessor;
    }
}
