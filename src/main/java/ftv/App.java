package ftv;

import ftv.items.IEnergyConsumer;
import ftv.items.IInventoryItem;
import ftv.items.ItemsFactory;
import ftv.items.Vehicle;
import ftv.service.IServiceCenter;
import ftv.service.IStorage;
import ftv.ui.IUI;
import ftv.ui.UICommands;

import java.util.List;

public class App {
    private IStorage storage;
    private IServiceCenter serviceCenter;
    private IUI ui;
    private ItemsFactory itemsFactory = new ItemsFactory();

    public App(IStorage storage, IServiceCenter serviceCenter, IUI ui) {
        this.storage = storage;
        this.serviceCenter = serviceCenter;
        this.ui = ui;
    }

    public void run() {
        ui.init();
        while (true) {
            var command = ui.getCommand();
            if (command == UICommands.Stop)
                break;
            switch (command) {
                case CreateItem -> {
                    var request = ui.getCreateRequest();
                    var status = addInventoryItem(itemsFactory.createItem(request));
                    ui.reportItemAdding(status);
                }
                case ReportEnergyConsumption -> {
                    ui.reportEnergyConsumption(getEnergyConsumption());
                }
                case ReportBeginnerVehicles -> {
                    ui.reportBeginnerVehicles(getBeginnerVehicles());
                }
                case ReportAllItems -> {
                    ui.reportAllItems(getInventoryItems());
                }
            }
        }
        ui.stop();
    }

    boolean addInventoryItem(IInventoryItem item) {
        if (storage.getItem(item.getId()) != null) return false;
        if (!serviceCenter.registerItem(item))
            return false;
        if (item instanceof Vehicle vehicle && !serviceCenter.checkVehicle(vehicle)) {
            return false;
        }
        storage.addItem(item);
        return true;
    }

    int addItems(List<IInventoryItem> items) {
        int cnt = 0;
        for (var item : items)
            if (addInventoryItem(item))
                cnt++;
        return cnt;
    }

    int getEnergyConsumption() {
        return storage.getVehicles().stream().filter(vehicle -> vehicle instanceof IEnergyConsumer)
                .mapToInt(vehicle -> ((IEnergyConsumer) vehicle).getEnergyConsumption())
                .sum();
    }

    List<Vehicle> getBeginnerVehicles() {
        return storage.getVehicles().stream()
                .filter(vehicle -> serviceCenter.beginnerCheck(vehicle))
                .toList();
    }

    List<IInventoryItem> getInventoryItems() {
        return storage.getItems();
    }
}
