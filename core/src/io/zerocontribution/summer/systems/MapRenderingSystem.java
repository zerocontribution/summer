package io.zerocontribution.summer.systems;

import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.managers.TagManager;
import com.artemis.systems.VoidEntitySystem;
import io.zerocontribution.summer.Constants;
import io.zerocontribution.summer.components.Camera;
import io.zerocontribution.summer.components.MapView;

public class MapRenderingSystem extends VoidEntitySystem {

    @Mapper
    ComponentMapper<Camera> cameraComponentMapper;

    @Mapper
    ComponentMapper<MapView> mapViewComponentMapper;

    Entity view;

    @Override
    protected void initialize() {
        view = world.getManager(TagManager.class).getEntity(Constants.Tags.VIEW);
    }

    protected void processSystem() {
        Camera camera = cameraComponentMapper.get(view);
        MapView mapView = mapViewComponentMapper.get(view);
        mapView.renderer.setView(camera.camera);
        mapView.renderer.render();
    }
}
