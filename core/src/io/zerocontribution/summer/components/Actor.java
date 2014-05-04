package io.zerocontribution.summer.components;

import com.artemis.Component;
import com.badlogic.gdx.utils.ObjectMap;
import io.zerocontribution.summer.struct.Delay;

public class Actor extends Component {
    // abilityID: cooldown delta
    public ObjectMap<Integer, Delay> abilities = new ObjectMap<Integer, Delay>();

    public int currentTarget;

    public boolean hasAbility(int abilityId) {
        return abilities.containsKey(abilityId);
    }

    public boolean isAbilityInCooldown(int abilityId) {
        return abilities.get(abilityId).isElapsed();
    }

    public void resetAbilityCooldown(int abilityId) {
        abilities.get(abilityId).reset();
    }

}
