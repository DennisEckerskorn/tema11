package com.denniseckerskorn.tema11.ejercicio05.inventory;

import com.denniseckerskorn.tema11.ejercicio05.gameobjects.GameObject;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private static final int INVENTORY_SIZE = 7;
    private List<Slot> slots;

    public Inventory() {
        slots = new ArrayList<>(INVENTORY_SIZE);
        initSlots();
    }

    private void initSlots() {
        for (int i = 0; i < slots.size(); i++) {
            slots.add(new Slot());
        }
    }

    public boolean addItemToInventory(GameObject gameObject) {
        for (Slot slot : slots) {
            if (slot.addObjectToStack(gameObject)) {
                return true;
            }
        }
        return false;
    }

    public boolean removeItemFromInventory(GameObject gameObject) {
        for (Slot slot : slots) {
            if (slot.removeObjectFromStack(gameObject)) {
                return true;
            }
        }
        return false;
    }

}
