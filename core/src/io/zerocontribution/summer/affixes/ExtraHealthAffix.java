package io.zerocontribution.summer.affixes;

/**
 * Increases health by 2-4x.
 */
public class ExtraHealthAffix implements Affix {
    public float getSpawnChance() {
        return 0;
    }

    public float getTriggerChance() {
        return 0;
    }

    public String toLog() {
        return "ExtraHealth";
    }
}
