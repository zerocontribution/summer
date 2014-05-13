package io.zerocontribution.summer.ai.modules;

import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.World;
import com.artemis.managers.GroupManager;
import com.artemis.managers.TagManager;
import com.artemis.utils.ImmutableBag;
import com.badlogic.gdx.math.Vector2;
import io.zerocontribution.summer.Constants;
import io.zerocontribution.summer.components.Condition;
import io.zerocontribution.summer.components.Position;
import io.zerocontribution.summer.components.Velocity;
import io.zerocontribution.summer.utils.MathUtils;

public class BasicVision extends AbstractAIModule {

    ComponentMapper<Position> positionMapper;

    ComponentMapper<Velocity> velocityMapper;

    ComponentMapper<Condition> conditionMapper;

    private final float range;

    private final float stopRange;

    private boolean spotted;

    /**
     * @param world
     * @param range Position range (pixels)
     */
    public BasicVision(World world, float range, float stopRange) {
        super(world);
        this.spotted = false;
        this.range = range;
        this.stopRange = stopRange;
    }

    @Override
    public void initialize() {
        positionMapper = world.getMapper(Position.class);
        velocityMapper = world.getMapper(Velocity.class);
        conditionMapper = world.getMapper(Condition.class);
    }

    @Override
    public boolean process(Entity e) {
        if (conditionMapper.get(e).state == Condition.State.DYING) {
            return true;
        }

        Entity player = world.getManager(TagManager.class).getEntity(Constants.Tags.PLAYER);

        if (conditionMapper.get(player).state == Condition.State.DYING) {
            return true;
        }

        Position entityPosition = positionMapper.get(e);
        Position playerPosition = positionMapper.get(player);

        float dst = Vector2.dst(entityPosition.x, entityPosition.y, playerPosition.x, playerPosition.y);

        if (!spotted) {
            if (dst < range) {
                entityPosition.setTarget(playerPosition);
                spotted = true;
                return false;
            } else {
                entityPosition.unsetTarget();
                return true;
            }
        } else {
            if (dst > stopRange) {
                spotted = false;

                Velocity velocity = velocityMapper.get(e);
                velocity.set(0, 0);
                entityPosition.unsetTarget();

                return true;
            } else {
                entityPosition.setTarget(playerPosition);
                return false;
            }
        }
    }
}