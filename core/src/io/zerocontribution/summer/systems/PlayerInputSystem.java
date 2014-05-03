package io.zerocontribution.summer.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.managers.TagManager;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Camera;
import com.google.inject.Inject;
import io.zerocontribution.summer.Constants;
import io.zerocontribution.summer.components.Player;
import io.zerocontribution.summer.components.Velocity;

public class PlayerInputSystem extends EntityProcessingSystem implements InputProcessor {

    @Inject
    InputMultiplexer inputMultiplexer;

    @Mapper
    ComponentMapper<Velocity> velocityMapper;

    private boolean up, down, left, right;

    Camera camera;

    @SuppressWarnings("unchecked")
    public PlayerInputSystem() {
        super(Aspect.getAspectForAll(Player.class));
    }

    @Override
    protected void initialize() {
        inputMultiplexer.addProcessor(this);

        Entity view = world.getManager(TagManager.class).getEntity(Constants.Tags.VIEW);
        camera = view.getComponent(io.zerocontribution.summer.components.Camera.class).camera;
    }

    protected void process(Entity e) {
        Velocity velocity = velocityMapper.get(e);

        velocity.x = 0;
        velocity.y = 0;

        if (left) {
            velocity.x = -Constants.PLAYER_SPEED;
        } else if (right) {
            velocity.x = Constants.PLAYER_SPEED;
        }

        if (up) {
            velocity.y = Constants.PLAYER_SPEED;
        } else if (down) {
            velocity.y = -Constants.PLAYER_SPEED;
        }
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Keys.W:
                up = true;
                down = false;
                break;

            case Keys.A:
                left = true;
                right = false;
                break;

            case Keys.S:
                down = true;
                up = false;
                break;

            case Keys.D:
                right = true;
                left = false;
                break;

            case Keys.NUM_1:
                break;

            case Keys.NUM_2:
            case Keys.NUM_3:
            case Keys.NUM_4:
            case Keys.NUM_5:
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Keys.W:
                up = false;
                break;

            case Keys.A:
                left = false;
                break;

            case Keys.S:
                down = false;
                break;

            case Keys.D:
                right = false;
                break;

            case Keys.TAB:
                break;
        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}
