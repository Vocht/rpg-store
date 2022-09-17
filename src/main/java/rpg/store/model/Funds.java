package rpg.store.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import rpg.store.exceptions.NotEnoughFundsException;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Funds {
    private int totalValue;

    public int getTotalValue() {
        return totalValue;
    }

    public void addFunds(int amount) {
        totalValue += amount;
    }

    public void removeFunds(int amount) throws NotEnoughFundsException {
        if (amount > totalValue) throw new NotEnoughFundsException(String.format("Not enough funds available: %d, need: %d", totalValue, amount));
        totalValue -= amount;
    }
}
