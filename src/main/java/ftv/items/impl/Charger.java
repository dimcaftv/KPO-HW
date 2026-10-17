package ftv.items.impl;

import ftv.items.InventoryItem;

public class Charger extends InventoryItem {
    @Override
    public String toString() {
        return String.format("Charger: %s", id);
    }
}
