package io.zerocontribution.summer.components;

import com.artemis.Component;

public class Velocity extends Component {
    public float x, y;

    public Velocity(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
