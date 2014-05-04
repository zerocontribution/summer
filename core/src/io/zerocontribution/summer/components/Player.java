package io.zerocontribution.summer.components;

import com.artemis.Component;

public class Player extends Component {
    public int lifetimeKills = 0;
    public int totalKills = 0;

    public void creditKill() {
        lifetimeKills++;
        totalKills++;
    }
}
