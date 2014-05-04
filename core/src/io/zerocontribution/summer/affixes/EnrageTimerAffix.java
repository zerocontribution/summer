package io.zerocontribution.summer.affixes;

/**
 * Adds a countdown timer. Once elapsed, all other affixes attributes are increased until the player or the enemy dies.
 */
public class EnrageTimerAffix implements Affix {
    public float getSpawnChance() {
        return 0;
    }

    public float getTriggerChance() {
        return 0;
    }

    public String toLog() {
        return "EnrageTimer";
    }
}
