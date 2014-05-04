package io.zerocontribution.summer.components;

import com.artemis.Component;
import com.badlogic.gdx.math.Rectangle;

public class Bounds extends Component {
    public Rectangle rect;

    public Bounds() {}
    public Bounds(Rectangle rect) {
        this.rect = rect;
    }
}
