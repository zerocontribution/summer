package io.zerocontribution.summer.affixes;

/**
 * Has a chance to fire a missle salvo at the player's surrounding area.
 */
public class MissleSalvoAffix implements Affix {
    public float getSpawnChance() {
        return 0;
    }

    public float getTriggerChance() {
        return 0;
    }

    public String toLog() {
        return "MissleSalvo";
    }
}
