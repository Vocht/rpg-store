package rpg.store.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rpg.store.exceptions.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    private Inventory inventory;

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
        inventory.addItem(new Potion());
        assertEquals(1, inventory.getItems().size());
    }

    @Test
    void inventory_removeItem_givenItemId_expectingItemToBeRemoved() throws NotFoundException {
        inventory.addItem(new Potion());
        assertEquals(1, inventory.getItems().size());
        inventory.removeItem(0);
        assertEquals(0, inventory.getItems().size());
    }

    @Test
    void inventory_removeItem_givenItemId_expectingNotFoundException() {
        assertThrows(NotFoundException.class, () -> inventory.removeItem(0));
    }
}