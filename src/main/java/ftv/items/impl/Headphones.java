package ftv.items.impl;

import ftv.items.InventoryItem;

public class Headphones extends InventoryItem {
    @Override
    public String toString() {
        return String.format("Headphones: %s", id);
    }
}
