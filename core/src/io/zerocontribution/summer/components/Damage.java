package io.zerocontribution.summer.components;

import com.artemis.Component;
import com.artemis.Entity;
import com.badlogic.gdx.utils.Array;

public class Damage extends Component {
    public Type type = Type.HEALTH;
    public int amount;
    public Array<Entity> targets = new Array<Entity>();

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
