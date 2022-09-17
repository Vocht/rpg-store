package rpg.store.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rpg.store.model.Store;

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
}