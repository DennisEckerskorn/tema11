package com.denniseckerskorn.tema11.ejercicio05.inventory;

import com.denniseckerskorn.tema11.ejercicio05.gameobjects.GameObject;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private static final int INITIAL_INVENTORY_SIZE = 7;
    private List<Slot> slots;
    private int cantidadStack;

    public Inventory() {
        this.slots = new ArrayList<>(INITIAL_INVENTORY_SIZE);
        this.cantidadStack = 0;
        calculateCurrentSlotCount();
        initSlots();
    }

    private void initSlots() {
        for (int i = 0; i < INITIAL_INVENTORY_SIZE; i++) {
            slots.add(new Slot());
        }
    }

    public boolean addItemToInventory(GameObject gameObject) {
        for (Slot slot : slots) {
            if (slot.addObjectToStack(gameObject)) {
                calculateCurrentSlotCount();
                return true;
            }
        }
        return false;
    }

    public boolean removeItemFromInventory(GameObject gameObject) {
        for (Slot slot : slots) {
            if (slot.removeObjectFromStack(gameObject)) {
                calculateCurrentSlotCount();
                return true;
            }
        }
        return false;
    }

    private void calculateCurrentSlotCount() {
        cantidadStack = 0;
        for (Slot slot : slots) {
            cantidadStack += slot.getGameObjects().size();
        }
    }

}
