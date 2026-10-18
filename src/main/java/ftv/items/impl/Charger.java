package ftv.items.impl;

import ftv.items.InventoryItem;

import java.util.UUID;

public class Charger extends InventoryItem {
    public Charger() {
    }

    public Charger(UUID id) {
        super(id);
    }

    @Override
    public String toString() {
        return String.format("Charger: %s", id);
    }
}
