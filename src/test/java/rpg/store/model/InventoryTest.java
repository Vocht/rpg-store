package rpg.store.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rpg.store.exceptions.NotFoundException;
import rpg.store.model.Inventory;
import rpg.store.model.Item;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    Inventory inventory;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
    }

    @Test
    void inventory_shouldHaveFunds() {
        var funds = inventory.getFunds();
        assertNotNull(funds);
    }

    @Test
    void inventory_shouldHaveItemsList() {
        var items = inventory.getItems();
        assertNotNull(items);
    }

    @Test
    void inventory_addItem_givenItem_expectingItemsToContainItem() {
        assertEquals(0, inventory.getItems().size());
        inventory.addItem(new Item());
        assertEquals(1, inventory.getItems().size());
    }

    @Test
    void inventory_removeItem_givenItemId_expectingItemToBeRemoved() throws NotFoundException {
        inventory.addItem(new Item(0, 0));
        assertEquals(1, inventory.getItems().size());
        inventory.removeItem(0);
        assertEquals(0, inventory.getItems().size());
    }

    @Test
    void inventory_removeItem_givenItemId_expectingNotFoundException() {
        assertThrows(NotFoundException.class, () -> inventory.removeItem(0));
    }
}