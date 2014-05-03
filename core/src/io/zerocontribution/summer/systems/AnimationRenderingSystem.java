package io.zerocontribution.summer.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.artemis.annotations.Mapper;
import com.artemis.utils.ImmutableBag;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.google.inject.Inject;
import io.zerocontribution.summer.Assets;
import io.zerocontribution.summer.components.*;

public class AnimationRenderingSystem extends EntitySystem {

    @Inject
    SpriteBatch spriteBatch;

    @Inject
    Assets assets;

    @Mapper
    ComponentMapper<AnimationName> animationMapper;

    @Mapper
    ComponentMapper<Position> positionMapper;

    @Mapper
    ComponentMapper<Dimensions> dimensionsMapper;

    @Mapper
    ComponentMapper<SpriteColor> spriteColorMapper;

    @SuppressWarnings("unchecked")
    public AnimationRenderingSystem() {
        super(Aspect.getAspectForAll(AnimationName.class, Position.class, Dimensions.class));
    }

    private void process(Entity e) {
        AnimationName name = animationMapper.get(e);
        Position position = positionMapper.get(e);
        Dimensions dimensions = dimensionsMapper.get(e);

        Color color = null;
        if (spriteColorMapper.has(e)) {
            SpriteColor spriteColor = spriteColorMapper.get(e);
            color = spriteBatch.getColor();
            spriteBatch.setColor(spriteColor.color);
        }

        spriteBatch.draw(assets.get(name.name, Texture.class), position.x, position.y, dimensions.width, dimensions.height);

        if (spriteColorMapper.has(e)) {
            spriteBatch.setColor(color);
        }
    }

    @Override
    protected void processEntities(ImmutableBag<Entity> entityImmutableBag) {
        spriteBatch.begin();
        for (int i = 0; i < entityImmutableBag.size(); i++) {
            process(entityImmutableBag.get(i));
        }
        spriteBatch.end();
    }

    @Override
    protected boolean checkProcessing() {
        return true;
    }
}
