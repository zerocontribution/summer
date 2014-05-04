package io.zerocontribution.summer.components;

import com.artemis.Component;

public class Expiring extends Component {
    public float expiration = 0;

    public Expiring(float expiration) {
        this.expiration = expiration;
    }
}
