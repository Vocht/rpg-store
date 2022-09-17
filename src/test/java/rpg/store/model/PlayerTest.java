package rpg.store.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rpg.store.model.Player;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlayerTest {

    Player player;

    @BeforeEach
    public void setUp() {
        player = new Player();
    }

    @Test
    void player_shouldHaveIntenvory() {
        var inventory = player.getInventory();
        assertNotNull(inventory);
    }
}
