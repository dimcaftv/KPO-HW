package ftv.ui;

import ftv.items.IInventoryItem;
import ftv.items.ItemTypes;
import ftv.items.Vehicle;

import java.util.List;

public interface IUI {
    void init();
    void stop();
    UICommands getCommand();
    ItemTypes getCreateRequest();
    void reportItemAdding(boolean status);
    void reportEnergyConsumption(int consumption);
    void reportBeginnerVehicles(List<Vehicle> vehicles);
    void reportAllItems(List<IInventoryItem> items);
}
