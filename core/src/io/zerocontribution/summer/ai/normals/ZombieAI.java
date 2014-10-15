package io.zerocontribution.summer.ai.normals;

import com.artemis.World;
import io.zerocontribution.summer.ai.AI;
import io.zerocontribution.summer.ai.modules.AIModule;
import io.zerocontribution.summer.ai.modules.BasicVision;

public class ZombieAI extends AI {

    final public static String NAME = "Zombie";

    final public String name = NAME;

    public ZombieAI(World world) {
        super(world);

        modules = new AIModule[3];
        modules[0] = new BasicVision(world, 250, 500);
//        modules[1] = new BasicFollow(world, 100, 100);
//        modules[2] = new BasicAttack(world, 50, 2);
    }
}
