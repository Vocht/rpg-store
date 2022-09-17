package rpg.store.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    private Item item;

    @BeforeEach
    void setUp() {
        item = new Item();
    }

    @Test
    void item_shouldHaveDefaultValue() {
        assertEquals(0, item.getValue());
    }

    @Test
    void item_shouldInitializeWithValue() {
        item = new Item(0, 10);
        assertEquals(10, item.getValue());
    }
}