package io.zerocontribution.summer.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.artemis.annotations.Mapper;
import com.artemis.managers.GroupManager;
import com.artemis.managers.TagManager;
import com.artemis.utils.ImmutableBag;
import com.esotericsoftware.minlog.Log;
import com.google.inject.Inject;
import io.zerocontribution.summer.Constants;
import io.zerocontribution.summer.components.Bounds;
import io.zerocontribution.summer.components.Drop;
import io.zerocontribution.summer.components.Inventory;
import io.zerocontribution.summer.components.Item;
import io.zerocontribution.summer.services.ItemService;

public class LootSystem extends EntitySystem {

    @Inject
    ItemService itemService;

    @Mapper
    ComponentMapper<Bounds> boundsMapper;

    @Mapper
    ComponentMapper<Drop> dropMapper;

    @Mapper
    ComponentMapper<Inventory> inventoryMapper;

    @SuppressWarnings("unchecked")
    public LootSystem() {
        super(Aspect.getAspectForAll(Drop.class, Bounds.class));
    }

    @Override
    protected boolean checkProcessing() {
        return world.getManager(GroupManager.class).getEntities(Constants.Groups.DROPS).size() > 0;
    }

    @Override
    protected void processEntities(ImmutableBag<Entity> entities) {
        Entity player = world.getManager(TagManager.class).getEntity(Constants.Tags.PLAYER);
        Bounds playerBounds = boundsMapper.get(player);

        for (int i = 0; i < entities.size(); i++) {
            Entity loot = entities.get(i);
            if (checkCollision(playerBounds, loot)) {
                pickUpLoot(player, loot);
            }
        }
    }

    private boolean checkCollision(Bounds playerBounds, Entity loot) {
        return playerBounds.rect.overlaps(boundsMapper.get(loot).rect);
    }

    private void pickUpLoot(Entity player, Entity loot) {
        Drop drop = dropMapper.get(loot);
        Inventory inventory = inventoryMapper.get(player);

        if (drop.itemId > 0) {
            Item item = itemService.get(drop.itemId);

            if (inventory.addItem(item)) {
                Log.info("Loot", "Picked up item " + drop.itemId);
            } else {
                Log.info("Loot", "Could not pick up item " + drop.itemId);
            }

            // TODO Notification of new item
        }

        world.deleteEntity(loot);
    }
}
