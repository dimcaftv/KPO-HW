package ftv.ui;

import ftv.items.IInventoryItem;
import ftv.items.ItemTypes;
import ftv.items.Vehicle;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements IUI {
    Scanner scanner = new Scanner(System.in);
    PrintStream writer = System.out;

    private void printCommands() {
        writer.println("""
                Commands:
                0 - exit
                1 - add item
                2 - print energy consumption
                3 - print vehicles for beginners
                4 - print all inventory items""");
    }

    @Override
    public void init() {
        writer.println("Start HSEKAT app");
    }

    @Override
    public void stop() {
        scanner.close();
        writer.close();
    }

    @Override
    public UICommands getCommand() {
        printCommands();
        while (true) {
            writer.print("Command: ");
            try {
                int ind = Integer.parseInt(scanner.nextLine().trim());
                writer.println();
                return UICommands.values()[ind];
            } catch (Exception _) {
                writer.println("Invalid command");
            }
        }
    }

    @Override
    public ItemTypes getCreateRequest() {
        writer.println("Types:");
        for (int i = 0; i < ItemTypes.values().length; i++) {
            writer.printf("%d - %s%n", i, ItemTypes.values()[i]);
        }
        writer.print("Choose: ");
        while (true) {
            try {
                return ItemTypes.values()[Integer.parseInt(scanner.nextLine().trim())];
            } catch (Exception _) {
                writer.print("Invalid type, try again: ");
            }
        }
    }

    @Override
    public void reportItemAdding(boolean status) {
        if (status) {
            writer.printf("Successfully added item%n%n");
        } else {
            writer.printf("Failed to add item%n%n");
        }
    }

    @Override
    public void reportEnergyConsumption(int consumption) {
        writer.printf("Total energy consumption: %d%n%n", consumption);
    }

    @Override
    public void reportBeginnerVehicles(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            writer.println("No vehicles found");
            return;
        }
        writer.println("Vehicles for beginners:");
        for (var vehicle : vehicles) {
            writer.printf("%s - easiness (%d)%n", vehicle, vehicle.getDifficulty());
        }
        writer.println();
    }

    @Override
    public void reportAllItems(List<IInventoryItem> items) {
        if (items.isEmpty()) {
            writer.println("No items found");
            return;
        }
        writer.println("All items:");
        for (var item : items) {
            writer.println(item);
        }
        writer.println();
    }
}
