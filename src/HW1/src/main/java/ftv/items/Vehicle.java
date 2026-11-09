package ftv.items;

import java.util.UUID;

public abstract class Vehicle extends InventoryItem {
    public Vehicle() {
    }

    public Vehicle(UUID id) {
        super(id);
    }

    public abstract int getDifficulty();
}
