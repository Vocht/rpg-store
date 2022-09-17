package model;

import interfaces.InventoryContainer;

public class Player implements InventoryContainer {
    public Inventory getInventory() {
        return new Inventory();
    }
}
