package rpg.store.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rpg.store.exceptions.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StoreTest {

    private Store store;

    @BeforeEach
    public void SetUp() {
        store = new Store();
    }

    @Test
    void store_shouldHaveInventory() {
        var inventory = store.getInventory();
        assertNotNull(inventory);
    }

    @Test
    void store_sellItem_givenAnItemId_expectingItemToBeRemovedAndFundsToBeIncreased() throws NotFoundException {
        store.getInventory().addItem(new Potion());

        assertEquals(1, store.getInventory().getItems().size());
        assertEquals(0, store.getInventory().getFunds().getTotalValue());

        store.sellItem(0);

        assertEquals(0, store.getInventory().getItems().size());
        assertEquals(5, store.getInventory().getFunds().getTotalValue());
    }
}