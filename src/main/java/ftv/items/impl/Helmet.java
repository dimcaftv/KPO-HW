package ftv.items.impl;

import ftv.items.InventoryItem;

public class Helmet extends InventoryItem {
    @Override
    public String toString() {
        return String.format("Helmet: %s", id);
    }
}
