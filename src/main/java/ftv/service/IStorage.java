package ftv.service;

import ftv.items.IInventoryItem;
import ftv.items.Vehicle;

import java.util.List;
import java.util.UUID;

public interface IStorage {
    void addItem(IInventoryItem item);

    List<IInventoryItem> getItems();

    List<Vehicle> getVehicles();

    IInventoryItem getItem(UUID id);
}
