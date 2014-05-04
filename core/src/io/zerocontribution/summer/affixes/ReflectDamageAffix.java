package io.zerocontribution.summer.affixes;

/**
 * Has a chance to reflect 1-5% damage back at the player.
 */
public class ReflectDamageAffix implements Affix {
    public float getSpawnChance() {
        return 0;
    }

    public float getTriggerChance() {
        return 0;
    }

    public String toLog() {
        return "ReflectsDamage";
    }
}
