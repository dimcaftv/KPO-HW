package ftv.items.impl;

import ftv.items.IEnergyConsumer;

import java.util.UUID;

public class ElectroBicycle extends Bicycle implements IEnergyConsumer {


    public ElectroBicycle() {
    }

    public ElectroBicycle(UUID id) {
        super(id);
    }

    @Override
    public int getDifficulty() {
        return 6;
    }

    @Override
    public int getEnergyConsumption() {
        return 42;
    }

    @Override
    public String toString() {
        return String.format("Electro Bicycle: %s", id);
    }
}
