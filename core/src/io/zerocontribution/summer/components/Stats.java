package io.zerocontribution.summer.components;

import com.artemis.Component;

public class Stats extends Component {
    public int level = 1;

    public int health = 100;

    public Stats() {}
    public Stats(int level) {
        this.level = level;
    }
}
