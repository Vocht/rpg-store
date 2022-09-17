package rpg.store.model;

import rpg.store.interfaces.InventoryContainer;

public class Store implements InventoryContainer {
    public Inventory getInventory() {
        return new Inventory();
    }
}
