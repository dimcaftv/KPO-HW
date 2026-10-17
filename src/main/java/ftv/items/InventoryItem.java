package ftv.items;

import java.util.UUID;

public abstract class InventoryItem implements IInventoryItem {
    protected UUID id;

    public InventoryItem() {}
    public InventoryItem(UUID id) {
        this.id = id;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return String.format("Item: %s", id);
    }
}
