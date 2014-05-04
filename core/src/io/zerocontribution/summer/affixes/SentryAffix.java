package io.zerocontribution.summer.affixes;

/**
 * Spawns sentry units that scan an area for a player and will fire at them if they run into the area.
 */
public class SentryAffix implements Affix {
    public float getSpawnChance() {
        return 0;
    }

    public float getTriggerChance() {
        return 0;
    }

    public String toLog() {
        return "Sentry";
    }
}
