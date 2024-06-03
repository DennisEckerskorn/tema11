package com.denniseckerskorn.tema11.ejercicio05.inventory;

import com.denniseckerskorn.lib.ConsoleMenu;
import com.denniseckerskorn.lib.LibIO;
import com.denniseckerskorn.tema11.ejercicio05.gameobjects.*;

import java.util.Stack;

public class InventoryMenu {
    private ConsoleMenu consoleMenu;
    private ConsoleMenu addMenu;
    private Inventory inventory;
    private GameObject gameObject;

    public InventoryMenu() {
        inventory = new Inventory();
        consoleMenu = new ConsoleMenu("Inventory Menu");
        consoleMenu.addOpcion("Add object to Inventory");
        consoleMenu.addOpcion("Remove object from Inventory");
        consoleMenu.addOpcion("Show Inventory");
        consoleMenu.addOpcion("Exit Menu");

        addMenu = new ConsoleMenu("Add Items:");
        addMenu.addOpcion("Sword");
        addMenu.addOpcion("Pick");
        addMenu.addOpcion("Stone");
        addMenu.addOpcion("Wood");
        addMenu.addOpcion("Egg");
        addMenu.addOpcion("EnderPerl");
        addMenu.addOpcion("Return to main menu");

        mainMenu();
    }

    private void mainMenu() {
        int option = -1;
        boolean valid = false;

        do {
            int opcion = consoleMenu.mostrarMenuInt();
            switch (opcion) {
                case 1:
                    addToInventory();
                    break;
                case 2:
                    removeFromInventory();
                    break;
                case 3:
                    showCurrentInventory();
                    break;
                case 4:
                    valid = true;
                    break;
                default:
                    System.out.println("The number is not in range.");
                    break;
            }
        } while (!valid);
    }

    private void addToInventory() {
        int optionAdd = addMenu.mostrarMenuInt();

        switch (optionAdd) {
            case 1:
                gameObject = new Espada();
                break;
            case 2:
                gameObject = new Pico();
                break;
            case 3:
                gameObject = new Piedra();
                break;
            case 4:
                gameObject = new Madera();
                break;
            case 5:
                gameObject = new Huevo();
                break;
            case 6:
                gameObject = new PerlaEnder();
                break;
            case 7:
                break;
            default:
                System.out.println("The number is not in range.");
                break;
        }

        if (inventory.addItemToInventory(gameObject)) {
            System.out.println("Added: " + gameObject);
        } else {
            System.out.println("Could not be added to the inventory");
        }
    }

    private void removeFromInventory() {
        showCurrentInventory();
        removeItem();
        showCurrentInventory();
    }

    private void showCurrentInventory() {
        System.out.println("Current Inventory");
        for (int i = 0; i < inventory.getSlots().size(); i++) {
            int slotCount = inventory.getCurrentSlotCount(i);
            System.out.println("Slot " + (i + 1) + ": " + inventory.getSlots().get(i).getGameObjects() + " Slot Count: " + slotCount);
        }
    }

    private void removeItem() {
        int option = LibIO.requestInt("Choose which object needs to be removed", 1, 7);
        for (int i = 0; i < inventory.getSlots().size(); i++) {
            if (option == i + 1) {
                Stack<GameObject> objects = inventory.getSlots().get(i).getGameObjects();
                if (!objects.isEmpty()) {
                    GameObject gameObjectRemoval = objects.peek();
                    System.out.println(gameObjectRemoval + " is being removed");
                    inventory.removeItemFromInventory(gameObjectRemoval);
                } else {
                    System.out.println("Slot " + (i + 1) + " is empty. No items to remove");
                }
            }
        }
    }
}
