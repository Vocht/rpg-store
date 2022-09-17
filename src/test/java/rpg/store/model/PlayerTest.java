package rpg.store.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rpg.store.exceptions.NotEnoughFundsException;
import rpg.store.exceptions.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    private Player player;
    private final Potion potion = new Potion();
    private final Sword sword = new Sword();
    private final Shield shield = new Shield();

    @BeforeEach
    public void setUp() {
        player = new Player();
    }

    @Test
    void player_shouldHaveIntenvory() {
        var inventory = player.getInventory();
        assertNotNull(inventory);
    }

    @Test
    void player_buyItem_givenStoreAndPotionId_expectingItemToBeAddedToInventoryAndFundsToDecrease() throws NotFoundException, NotEnoughFundsException {
        player.getInventory().getFunds().addFunds(15);
        var store = new Store();
        store.getInventory().addItem(potion);

        player.buyItem(store, potion.getId());
        assertEquals(10, player.getInventory().getFunds().getTotalValue());
        assertEquals(1, player.getInventory().getItems().size());
    }

    @Test
    void player_buyItem_givenStoreAndSwordId_expectingItemToBeAddedToInventoryAndFundsToDecrease() throws NotFoundException, NotEnoughFundsException {
        player.getInventory().getFunds().addFunds(15);
        var store = new Store();
        store.getInventory().addItem(sword);

        player.buyItem(store, sword.getId());
        assertEquals(0, player.getInventory().getFunds().getTotalValue());
        assertEquals(1, player.getInventory().getItems().size());
    }

    @Test
    void player_buyItem_givenStoreAndShieldId_expectingItemToBeAddedToInventoryAndFundsToDecrease() throws NotFoundException, NotEnoughFundsException {
        player.getInventory().getFunds().addFunds(15);
        var store = new Store();
        store.getInventory().addItem(shield);

        player.buyItem(store, shield.getId());
        assertEquals(0, player.getInventory().getFunds().getTotalValue());
        assertEquals(1, player.getInventory().getItems().size());
    }

    @Test
    void player_buyItem_givenStoreWithThreeItemsAndShieldId_expectingItemToBeAddedToInventoryAndFundsToDecrease() throws NotFoundException, NotEnoughFundsException {
        player.getInventory().getFunds().addFunds(15);
        var store = new Store();
        store.getInventory().addItem(potion);
        store.getInventory().addItem(sword);
        store.getInventory().addItem(shield);

        player.buyItem(store, shield.getId());
        assertEquals(0, player.getInventory().getFunds().getTotalValue());
        assertEquals(1, player.getInventory().getItems().size());
        assertEquals(2, store.getInventory().getItems().size());
    }
}
