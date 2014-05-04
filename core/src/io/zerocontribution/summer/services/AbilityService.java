package io.zerocontribution.summer.services;

import com.badlogic.gdx.utils.ArrayMap;
import io.zerocontribution.summer.abilities.Ability;

public class AbilityService {
    ArrayMap<Integer, Ability> abilities = new ArrayMap<Integer, Ability>();
    private int incrementer = 0;

    public AbilityService() {

    }

    private void add(Ability ability) {
        ability.id = incrementer++;
        abilities.put(ability.id, ability);
    }

    public Ability get(int id) {
        return abilities.get(id);
    }
}
