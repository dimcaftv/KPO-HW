package ftv.service;

import ftv.items.IInventoryItem;
import ftv.items.Vehicle;

import java.util.*;

public class Storage implements IStorage {
    private Map<UUID, IInventoryItem> items;

    public Storage() {
        items = new HashMap<>();
    }

    @Override
    public void addItem(IInventoryItem item) {
        items.put(item.getId(), item);
    }

    @Override
    public List<IInventoryItem> getItems() {
        return new ArrayList<>(items.values());
    }

    @Override
    public List<Vehicle> getVehicles() {
        return items.values().stream()
                .filter(item -> item instanceof Vehicle)
                .map(item -> ((Vehicle) item))
                .toList();
    }

    @Override
    public IInventoryItem getItem(UUID id) {
        if (id == null)
            return null;
        return items.get(id);
    }
}
