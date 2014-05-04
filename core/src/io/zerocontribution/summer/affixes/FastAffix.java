package io.zerocontribution.summer.affixes;

/**
 * Doubles speed.
 */
public class FastAffix implements Affix {
    public float getSpawnChance() {
        return 0;
    }

    public float getTriggerChance() {
        return 0;
    }

    public String toLog() {
        return "Fast";
    }
}
