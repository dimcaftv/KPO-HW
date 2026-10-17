package ftv.items.impl;

import ftv.items.Vehicle;

public class Bicycle extends Vehicle {

    @Override
    public int getDifficulty() {
        return 4;
    }

    @Override
    public String toString() {
        return String.format("Bicycle: %s", id);
    }
}
