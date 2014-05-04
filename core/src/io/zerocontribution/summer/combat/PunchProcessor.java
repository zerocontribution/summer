package io.zerocontribution.summer.combat;

import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.World;
import com.artemis.managers.GroupManager;
import com.artemis.managers.TagManager;
import com.artemis.utils.ImmutableBag;
import com.esotericsoftware.minlog.Log;
import io.zerocontribution.summer.Constants;
import io.zerocontribution.summer.components.*;

public class PunchProcessor implements CombatProcessor {

    World world;

    ComponentMapper<Position> positionMapper;

    ComponentMapper<Stats> statsMapper;

    ComponentMapper<Action> actionMapper;

    @Override
    public void initialize(World world) {
        this.world = world;
        positionMapper = world.getMapper(Position.class);
        statsMapper = world.getMapper(Stats.class);
        actionMapper = world.getMapper(Action.class);
    }

    @Override
    public void process(Entity ability) {
        Action action = actionMapper.get(ability);

        Damage damage = new Damage();
        damage.amount = 30;
        damage.type = Damage.Type.HEALTH;

        if (action.target != null && collision(action.source, action.target)
                || (action.source.getComponent(Player.class) == null
                && collision(action.source, world.getManager(TagManager.class).getEntity(Constants.Tags.PLAYER)))) {
            applyDamage(damage, action, action.target);
        } else {
            ImmutableBag<Entity> potentialTargets = world.getManager(GroupManager.class).getEntities(Constants.Groups.ENEMIES);
            for (int i = 0; i < potentialTargets.size(); i++) {
                if (collision(action.source, potentialTargets.get(i))) {
                    applyDamage(damage, action, potentialTargets.get(i));
                }
            }
        }

        ability.addComponent(damage);
        ability.changedInWorld();
    }

    private boolean collision(Entity source, Entity target) {
        return collision(positionMapper.get(source), positionMapper.get(target));
    }

    private boolean collision(Position sourcePosition, Position targetPosition) {
        float dst = (float) Math.hypot(
                Math.abs(sourcePosition.x - targetPosition.x),
                Math.abs(sourcePosition.y - targetPosition.y)
        );

        return dst <= 50;
    }

    private void applyDamage(Damage damage, Action action, Entity target) {
        Log.info("PunchProcessor", action.source + " -> " + target);
        damage.targets.add(target);
    }
}
