package io.zerocontribution.summer;

import com.google.inject.Injector;

/**
 * @todo I don't like this class.
 */
public class AppInjector {
    public static Injector injector;

    public static void setInjector(Injector instance) {
        injector = instance;
    }
}
