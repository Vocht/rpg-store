package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FundsTest {

    private Funds funds;

    @BeforeEach
    void setUp() {
        funds = new Funds();
    }

    @Test
    void funds_shouldHaveTotalValue() {
        var totalValue = funds.getTotalValue();
        assertEquals(0, totalValue);
    }
}