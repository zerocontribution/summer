package io.zerocontribution.summer.components;

import com.artemis.Component;
import com.artemis.Entity;

public class Damage extends Component {
    public Type type = Type.HEALTH;
    public int amount;
    public Entity[] targets;

    public enum Type {
        HEALTH("health");

        private String text;

        private Type(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }
}
