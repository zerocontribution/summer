package io.zerocontribution.summer.components;

import com.artemis.Component;

public class Item extends Component {
    public int id;
    public String name;
    public Slot slot;

    public Item(String name, Slot slot) {
        this.name = name;
        this.slot = slot;
    }

    public enum Slot {
        HEAD("Head"),
        PRIMARY("Primary Weapon"),
        SECONDARY("Secondary Weapon"),
        SHOES("Shoes");

        private String text;

        private Slot(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }
}
