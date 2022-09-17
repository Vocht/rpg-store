package rpg.store.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rpg.store.exceptions.NotEnoughFundsException;

import static org.junit.jupiter.api.Assertions.*;

class FundsTest {

    private Funds funds;

    @BeforeEach
    void setUp() {
        funds = new Funds();
    }

    @Test
    void funds_shouldInitializeWithDefaultValue() {
        assertEquals(0, funds.getTotalValue());
    }

    @Test
    void funds_shouldInitializeWithValue() {
        funds = new Funds(10);
        assertEquals(10, funds.getTotalValue());
    }

    @Test
    void funds_addFunds_givenAValue_expectingFundsToBeIncreasedByValue() {
        assertEquals(0, funds.getTotalValue());
        funds.addFunds(10);
        assertEquals(10, funds.getTotalValue());
    }

    @Test
    void funds_removeFunds_givenAValue_expectingFundsToBeDecreasedByValue() throws NotEnoughFundsException {
        funds = new Funds(10);
        funds.removeFunds(5);
        assertEquals(5, funds.getTotalValue());
    }

    @Test
    void funds_removeFunds_givenAValueHigherThanTotalValue_expectingNotEnoughFundsException() {
        funds = new Funds(10);
        assertThrows(NotEnoughFundsException.class, () -> funds.removeFunds(15));
    }
}