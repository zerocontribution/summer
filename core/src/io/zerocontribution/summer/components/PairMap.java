package io.zerocontribution.summer.components;

import com.artemis.Component;
import com.badlogic.gdx.utils.ObjectMap;
import io.zerocontribution.summer.struct.Pair;

public class PairMap extends Component {
    public ObjectMap<Pair, Boolean> map = new ObjectMap<Pair, Boolean>();
}
