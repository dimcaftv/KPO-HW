package ftv.service;

import ftv.items.IInventoryItem;
import ftv.items.Vehicle;

import java.util.UUID;

public interface IServiceCenter {
    UUID getNewId();
    boolean registerItem(IInventoryItem item);
    boolean checkVehicle(Vehicle vehicle);
    boolean beginnerCheck(Vehicle vehicle);
}
