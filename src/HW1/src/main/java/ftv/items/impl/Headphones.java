package ftv.items.impl;

import ftv.items.InventoryItem;

import java.util.UUID;

public class Headphones extends InventoryItem {
    public Headphones() {
    }

    public Headphones(UUID id) {
        super(id);
    }

    @Override
    public String toString() {
        return String.format("Headphones: %s", id);
    }
}
