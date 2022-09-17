package model;

import interfaces.InventoryContainer;

public class Store implements InventoryContainer {
    public Inventory getInventory() {
        return new Inventory();
    }
}
