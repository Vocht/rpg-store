package rpg.store.model;

import rpg.store.exceptions.NotEnoughFundsException;
import rpg.store.exceptions.NotFoundException;
import rpg.store.interfaces.InventoryContainer;

public class Player implements InventoryContainer {
    private final Inventory inventory = new Inventory();
    public Inventory getInventory() {
        return inventory;
    }

    public void buyItem(Store store, int id) throws NotFoundException, NotEnoughFundsException {
        var item = store.sellItem(id);
        inventory.getFunds().removeFunds(item.getValue());
        inventory.addItem(item);
    }
}
