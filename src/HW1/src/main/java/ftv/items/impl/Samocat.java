package ftv.items.impl;

import ftv.items.Vehicle;

import java.util.UUID;

public class Samocat extends Vehicle {

    public Samocat() {
    }

    public Samocat(UUID id) {
        super(id);
    }

    @Override
    public int getDifficulty() {
        return 8;
    }

    @Override
    public String toString() {
        return String.format("Samocat: %s", id);
    }
}
