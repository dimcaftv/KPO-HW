package ftv.items.impl;

import ftv.items.InventoryItem;

import java.util.UUID;

public class Helmet extends InventoryItem {

    public Helmet() {
    }

    public Helmet(UUID id) {
        super(id);
    }

    @Override
    public String toString() {
        return String.format("Helmet: %s", id);
    }
}
