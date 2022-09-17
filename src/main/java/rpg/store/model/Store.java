package rpg.store.model;

import rpg.store.exceptions.NotFoundException;
import rpg.store.interfaces.InventoryContainer;

public class Store implements InventoryContainer {
    private final Inventory inventory = new Inventory();
    public Inventory getInventory() {
        return inventory;
    }

    public Item sellItem(int id) throws NotFoundException {
        var item = inventory.removeItem(id);
        inventory.getFunds().addFunds(item.getValue());
        return item;
    }
}
