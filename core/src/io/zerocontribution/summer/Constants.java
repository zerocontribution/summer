package io.zerocontribution.summer;

public class Constants {
    public final static float PLAYER_SPEED = 240;
    public static class Tags {
        /**
         * The map entity; which has the actual map renderer and camera.
         */
        public final static String VIEW = "view";

        /**
         * The player entity.
         */
        public final static String PLAYER = "player";
    }

    public static class Groups {
        /**
         * All loot drop entities.
         */
        public final static String DROPS = "drops";

        /**
         * All enemies, alive or dead.
         */
        public final static String ENEMIES = "enemies";
    }
}
