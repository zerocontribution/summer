package io.zerocontribution.summer.affixes;

/**
 * Has a chance to heal itself during combat for 5-25% health.
 */
public class HealerAffix implements Affix {
    public float getSpawnChance() {
        return 0;
    }

    public float getTriggerChance() {
        return 0;
    }

    public String toLog() {
        return "Healer";
    }
}
