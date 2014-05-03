package io.zerocontribution.summer.screens;

import com.artemis.Entity;
import com.artemis.World;
import com.artemis.managers.TagManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.google.inject.Inject;
import io.zerocontribution.summer.AppInjector;
import io.zerocontribution.summer.Assets;
import io.zerocontribution.summer.Constants;
import io.zerocontribution.summer.components.*;
import io.zerocontribution.summer.systems.AnimationRenderingSystem;
import io.zerocontribution.summer.systems.CameraSystem;
import io.zerocontribution.summer.systems.MapRenderingSystem;

public class GameScreen extends AbstractScreen {

    @Inject
    SpriteBatch spriteBatch;

    @Inject
    Assets assets;

    World world;

    @Override
    public void show() {
        super.show();

        assets.loadGroup("base");
        assets.finishLoading(); // TODO Move this stuff to a loading screen instead... someday.

        world = new World();
        world.setManager(new TagManager());

        world.setSystem(new MapRenderingSystem());
        world.setSystem(new CameraSystem());
        world.setSystem(AppInjector.injector.getInstance(AnimationRenderingSystem.class));

        createPlayer();
        createView(new TmxMapLoader().load("maps/sewers.tmx"));

        world.initialize();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        world.setDelta(delta);
        world.process();
    }

    private void createPlayer() {
        Entity e = world.createEntity();

        e.addComponent(new Position(5, 5));
        e.addComponent(new Condition());
        e.addComponent(new AnimationName("square.png"));
        e.addComponent(new SpriteColor(Color.BLUE));
        e.addComponent(new Dimensions(20, 20));

        world.getManager(TagManager.class).register(Constants.Tags.PLAYER, e);
        e.addToWorld();
    }

    private void createView(TiledMap map) {
        Entity e = world.createEntity();

        Camera camera = new Camera();
        camera.camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.camera.position.x = camera.camera.viewportWidth / 2;
        camera.camera.position.y = camera.camera.viewportHeight / 2;
        camera.camera.update();
        spriteBatch.setProjectionMatrix(camera.camera.combined);
        e.addComponent(camera);

        MapView view = new MapView();
        view.renderer = new OrthogonalTiledMapRenderer(map, spriteBatch);
        e.addComponent(view);

        world.getManager(TagManager.class).register(Constants.Tags.VIEW, e);
        e.addToWorld();
    }

}
