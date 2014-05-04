package io.zerocontribution.summer.affixes;

public interface Affix {

    /**
     * Chance the affix has to be applied to an elite when spawning.
     */
    public float getSpawnChance();

    /**
     * Chance the affix has to be triggered on an active elite.
     */
    public float getTriggerChance();

    /**
     * A log representation of the affix.
     */
    public String toLog();

}
