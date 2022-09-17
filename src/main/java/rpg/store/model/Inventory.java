package rpg.store.model;

import lombok.Getter;
import rpg.store.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Inventory {
    private final Funds funds = new Funds();
    private final List<Item> items = new ArrayList<>();
    public void addItem(Item item) {
        items.add(item);
    }

    public Item removeItem(int id) throws NotFoundException {
        var item = getItemById(id);
        items.remove(item);

        return item;
    }

    private Item getItemById(int id) throws NotFoundException {
        var optionalItem = items.stream()
                .filter(i -> i.getId() == id)
                .findFirst();

        return optionalItem.orElseThrow(() -> new NotFoundException(String.format("Item with ID %d not found", id)));
    }
}
