package io.zerocontribution.summer.systems;

import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.managers.TagManager;
import com.artemis.systems.VoidEntitySystem;
import io.zerocontribution.summer.Constants;
import io.zerocontribution.summer.components.Camera;
import io.zerocontribution.summer.components.Position;

public class CameraSystem extends VoidEntitySystem {
    @Mapper
    ComponentMapper<Camera> camMapper;

    @Mapper
    ComponentMapper<Position> positionMapper;

    private Entity player;
    private Entity camera;

    @Override
    public void initialize() {
        player = world.getManager(TagManager.class).getEntity(Constants.Tags.PLAYER);
        camera = world.getManager(TagManager.class).getEntity(Constants.Tags.VIEW);
    }

    @Override
    protected boolean checkProcessing() {
        return player != null && positionMapper.has(player);
    }

    @Override
    protected void processSystem() {
        Camera cam = camMapper.get(camera);
        Position position = positionMapper.get(player);
        cam.camera.position.x = position.x;
        cam.camera.position.y = position.y;
        cam.camera.update();
    }
}
