package io.zerocontribution.summer.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.maps.Map;
import io.zerocontribution.summer.components.Bounds;
import io.zerocontribution.summer.components.Position;
import io.zerocontribution.summer.components.Velocity;

public class MovementSystem extends EntityProcessingSystem {
    @Mapper
    ComponentMapper<Position> positionMapper;

    @Mapper
    ComponentMapper<Velocity> velocityMapper;

    @Mapper
    ComponentMapper<Bounds> boundsMapper;

    Map currentMap;

    @SuppressWarnings("unchecked")
    public MovementSystem(Map currentMap) {
        super(Aspect.getAspectForAll(Position.class, Velocity.class, Bounds.class));
        this.currentMap = currentMap;
    }

    @Override
    protected boolean checkProcessing() {
        return true;
    }

    protected void process(Entity e) {
        Position position = positionMapper.get(e);
        Velocity velocity = velocityMapper.get(e);
        Bounds bounds = boundsMapper.get(e);

        if (velocity.x != 0 || velocity.y != 0) {
            position.x += velocity.x * world.delta;
            position.y += velocity.y * world.delta;
            bounds.rect.x = position.x;
            bounds.rect.y = position.y;
        }
    }
}
