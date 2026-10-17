package ftv.items.impl;

import ftv.items.IEnergyConsumer;

public class ElectroBicycle extends Bicycle implements IEnergyConsumer {


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
