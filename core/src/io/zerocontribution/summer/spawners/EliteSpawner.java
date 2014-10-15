package io.zerocontribution.summer.spawners;

import com.artemis.Entity;
import com.artemis.World;
import com.artemis.managers.GroupManager;
import com.artemis.managers.TagManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.esotericsoftware.minlog.Log;
import io.zerocontribution.summer.Constants;
import io.zerocontribution.summer.components.*;

public class EliteSpawner extends Spawner {
    private boolean shouldSpawn = true;
    public void spawn(World world) {
        Entity player = world.getManager(TagManager.class).getEntity(Constants.Tags.PLAYER);

        Entity e = world.createEntity();
        e.addComponent(new Condition());
        e.addComponent(new Position(5, 5));
        e.addComponent(new Velocity(0, 0));
        e.addComponent(new Dimensions(20, 20));
        e.addComponent(new Bounds(new Rectangle(5, 5, 20, 20)));
        e.addComponent(new SpriteColor(Color.RED));
        e.addComponent(new AnimationName("square.png"));

        int levelDifference = generateLevelDifference();
        int playerLevel = player.getComponent(Stats.class).level;
        e.addComponent(new Stats(playerLevel + levelDifference));
        e.addComponent(new Affixes(levelDifference));
        e.addComponent(new Npc())

        Log.info("EliteSpawner", "Elite[" + e.getComponent(Affixes.class).toLog() + "] created");

        world.getManager(GroupManager.class).add(e, Constants.Groups.ENEMIES);

        e.addToWorld();
    }

    private int generateLevelDifference() {
        return MathUtils.random(0, 5);
    }

    @Override
    public boolean shouldSpawn(World world) {
        //MathUtils.randomBoolean(0.1f);
        if (shouldSpawn) {
            shouldSpawn = false;
            return true;
        }
        return false;
    }
}
