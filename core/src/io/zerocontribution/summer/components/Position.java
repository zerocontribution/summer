package io.zerocontribution.summer.components;

import com.artemis.Component;

// TODO Change to using Vector2 for various positions.
public class Position extends Component {
    public float x, y, gridX, gridY;
    public float targetX, targetY, targetGridX, targetGridY;

    public Position(float gridX, float gridY) {
        this.gridX = gridX;
        this.gridY = gridY;
    }

    public Position(float gridX, float gridY, float worldX, float worldY) {
        this.gridX = gridX;
        this.gridY = gridY;
        x = worldX;
        y = worldY;
    }

    public void setTarget(Position position) {
        targetX = position.targetX;
        targetY = position.targetY;
        targetGridX = position.targetGridX;
        targetGridY = position.targetGridY;
    }

    public void unsetTarget() {
        targetX = -1;
        targetY = -1;
        targetGridX = -1;
        targetGridY = -1;
    }
}
