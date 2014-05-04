package io.zerocontribution.summer.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.esotericsoftware.minlog.Log;
import io.zerocontribution.summer.components.*;

public class DamageProcessingSystem extends EntityProcessingSystem {

    @Mapper
    ComponentMapper<Damage> damageMapper;

    @Mapper
    ComponentMapper<Stats> statsMapper;

    @Mapper
    ComponentMapper<Condition> conditionMapper;

    @SuppressWarnings("unchecked")
    public DamageProcessingSystem() {
        super(Aspect.getAspectForAll(Damage.class));
    }

    @Override
    protected void process(Entity action) {
        Damage damage = damageMapper.get(action);
        Entity source = action.getComponent(Action.class).source;

        switch (damage.type) {
            case HEALTH:
                processHealthDamage(action, damage, source);
                break;

            default:
                throw new RuntimeException("Unknown damage type, " + damage.type);
        }

        action.removeComponent(Damage.class);
        action.changedInWorld();
    }

    private void processHealthDamage(Entity action, Damage damage, Entity source) {
        for (Entity target : damage.targets) {
            Stats stats = statsMapper.get(target);
            if (stats.health > 0) {
                stats.health -= damage.amount;
                Log.info("DamageProcessor", source.toString() + " hits " + target + " for " + damage.amount + " health");

                if (stats.health <= 0) {
                    Condition condition = conditionMapper.get(target);
                    condition.state = Condition.State.DYING;

                    Log.info("DamageProcessor", source.toString() + " killed " + target);
                    creditKill(source, target);
                }
            }
        }
    }

    private void creditKill(Entity source, Entity target) {
        Player player = source.getComponent(Player.class);
        if (player != null) {
            player.creditKill();
            createRandomDrop(target.getComponent(Position.class));
        }
    }

    private void createRandomDrop(Position target) {
        Entity e = world.createEntity();
        e.addComponent(new Drop());
        e.addComponent(new Bounds(new Rectangle(target.x - 1, target.y - 1, 10, 10)));
        e.addComponent(new Dimensions(10, 10));
        e.addComponent(new Position(target.x - 1, target.y - 1));
        e.addComponent(new SpriteColor(Color.YELLOW));
        e.addToWorld();
    }

}
