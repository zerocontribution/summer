package io.zerocontribution.summer.utils;

import com.badlogic.gdx.math.Vector2;

public class MathUtils {
    public static Vector2 toGridVector(float x, float y, float tileSize) {
        return new Vector2(
                x * tileSize,
                y * tileSize
        );
    }
}
