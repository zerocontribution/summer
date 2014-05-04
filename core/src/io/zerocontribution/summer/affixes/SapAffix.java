package io.zerocontribution.summer.affixes;

/**
 * Has a chance to slow the player.
 */
public class SapAffix implements Affix {
    public float getSpawnChance() {
        return 0;
    }

    public float getTriggerChance() {
        return 0;
    }

    public String toLog() {
        return "Sap";
    }
}
