package ftv.items.impl;

import ftv.items.Vehicle;

public class Samocat extends Vehicle {

    @Override
    public int getDifficulty() {
        return 8;
    }

    @Override
    public String toString() {
        return String.format("Samocat: %s", id);
    }
}
