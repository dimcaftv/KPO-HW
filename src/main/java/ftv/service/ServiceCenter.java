package ftv.service;

import ftv.items.IInventoryItem;
import ftv.items.Vehicle;

import java.util.Random;
import java.util.UUID;

public class ServiceCenter implements IServiceCenter {
    private int inspectionThreshold;
    private int beginnerThreshold;

    public ServiceCenter(int inspectionThreshold, int beginnerThreshold) {
        this.inspectionThreshold = inspectionThreshold;
        this.beginnerThreshold = beginnerThreshold;
    }


    @Override
    public UUID getNewId() {
        return UUID.randomUUID();
    }

    @Override
    public boolean registerItem(IInventoryItem item) {
        if (item.getId() != null)
            return false;

        item.setId(getNewId());
        return true;
    }

    @Override
    public boolean checkVehicle(Vehicle vehicle) {
        return (new Random().nextInt(100)) >= inspectionThreshold;
    }

    @Override
    public boolean beginnerCheck(Vehicle vehicle) {
        return vehicle.getDifficulty() >= beginnerThreshold;
    }
}
