package rpg.store.model;

import rpg.store.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public Funds getFunds() {
        return new Funds();
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item removeItem(int id) throws NotFoundException {
        var optionalItem = items.stream()
                .filter(i -> i.getId() == id)
                .findFirst();
        var item = optionalItem.orElseThrow(() -> new NotFoundException(String.format("Item with ID %o not found", id)));
        items.remove(item);

        return item;
    }
}
