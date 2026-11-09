package ftv.items.impl;

import ftv.items.Vehicle;

import java.util.UUID;

public class Bicycle extends Vehicle {
    public Bicycle() {
    }

    public Bicycle(UUID id) {
        super(id);
    }

    @Override
    public int getDifficulty() {
        return 4;
    }

    @Override
    public String toString() {
        return String.format("Bicycle: %s", id);
    }
}
