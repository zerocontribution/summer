package io.zerocontribution.summer.services;

import com.badlogic.gdx.utils.ArrayMap;
import io.zerocontribution.summer.components.Item;

/**
 * @todo Replace this with a custom AssetLoader and just store it in the AssetManager. It would be nicer to manage
 *       all of this with a JSON file instead.
 */
public class ItemService {

    ArrayMap<Integer, Item> items = new ArrayMap<Integer, Item>();
    private int incrementer = 0;

    public ItemService() {
        add(new Item("Shank", Item.Slot.PRIMARY));
    }

    private void add(Item item) {
        item.id = incrementer++;
        items.put(item.id, item);
    }

    public Item get(int id) {
        return items.get(id);
    }

}
