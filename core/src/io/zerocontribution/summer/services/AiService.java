package io.zerocontribution.summer.services;

import com.artemis.World;
import io.zerocontribution.summer.ai.AI;
import io.zerocontribution.summer.ai.normals.ZombieAI;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class AiService {

    private static HashMap<String, Class> registry = new HashMap<String, Class>() {
        {
            put(ZombieAI.NAME, ZombieAI.class);
        }
    };

    @SuppressWarnings("unchecked")
    public AI getNew(String name, World world) {
        if (registry.containsKey(name)) {
            try {
                return (AI) registry.get(name).getConstructor(World.class).newInstance(world);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        throw new IllegalArgumentException("AI Normal '" + name + "' does not exist");
    }
}
