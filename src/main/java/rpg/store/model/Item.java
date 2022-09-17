package rpg.store.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Item {
    protected String name;
    protected int id;
    protected int value;
}
