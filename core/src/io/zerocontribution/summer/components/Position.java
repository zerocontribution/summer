package io.zerocontribution.summer.components;

import com.artemis.Component;

public class Position extends Component {
    public float x, y;
    public float gridX, gridY;

    public Position(float gridX, float gridY) {
        this.gridX = gridX;
        this.gridY = gridY;
    }
}
