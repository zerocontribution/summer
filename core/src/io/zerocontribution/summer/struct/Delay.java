package io.zerocontribution.summer.struct;

import java.util.concurrent.TimeUnit;

// TODO: Needs a pool class.
public class Delay {
    public long duration;

    public long start;
    public long expiration;

    public Delay() {}
    public Delay(long durationSeconds) {
        duration = durationSeconds;
        reset();
    }

    public boolean isElapsed() {
        return expiration >= System.currentTimeMillis();
    }

    public void reset() {
        start = System.currentTimeMillis();
        expiration = start + TimeUnit.SECONDS.toMillis(duration);
    }
}

