package rpg.store.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    private Item item;

    @BeforeEach
    void setUp() {
        item = new Potion();
    }

    @Test
    void item_shouldHaveDefaultValue() {
        assertEquals(5, item.getValue());
    }

    @Test
    void item_shouldInitializeWithValueAndIdAndName() {
        assertEquals("Potion", item.getName());
        assertEquals(0, item.getId());
        assertEquals(5, item.getValue());
    }
}