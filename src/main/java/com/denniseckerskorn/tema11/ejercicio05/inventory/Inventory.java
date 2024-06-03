package com.denniseckerskorn.tema11.ejercicio05.inventory;

import com.denniseckerskorn.tema11.ejercicio05.gameobjects.GameObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Inventory {
    private static final int INITIAL_INVENTORY_SIZE = 7;
    private List<Slot> slots;
    private int cantidadStack;

    public Inventory() {
        this.slots = new ArrayList<>(INITIAL_INVENTORY_SIZE);
        this.cantidadStack = 0;
        initSlots();
        calculateCurrentSlotCount();
    }

    private void initSlots() {
        for (int i = 0; i < INITIAL_INVENTORY_SIZE; i++) {
            slots.add(new Slot());
        }
    }

    public boolean addItemToInventory(GameObject gameObject) {
        for (Slot slot : slots) {
            if (slot.isSameType(gameObject) && slot.addObjectToStack(gameObject)) {
                calculateCurrentSlotCount();
                return true;
            }
        }

        //Encontrar un slot vacío para el objeto nuevo.
        for (Slot slot : slots) {
            if (slot.isEmpty()) {
                if (slot.addObjectToStack(gameObject)) {
                    calculateCurrentSlotCount();
                    return true;
                }
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
        cantidadStack = 0; // Reinicia cantidadStack antes de recalcular
        for (Slot slot : slots) {
            cantidadStack += slot.getCurrentSize();
        }
    }

    public int getCurrentSlotCount(int slotIndex) {
        if (slotIndex < 0 || slotIndex >= slots.size()) {
            return 0;
        }
        return slots.get(slotIndex).getCurrentSize();
    }


    public List<Slot> getSlots() {
        return slots;
    }

    public int getCantidadStack() {
        return cantidadStack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inventory inventory = (Inventory) o;
        return cantidadStack == inventory.cantidadStack && Objects.equals(slots, inventory.slots);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(slots);
        result = 31 * result + cantidadStack;
        return result;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "slots=" + slots +
                ", cantidadStack=" + cantidadStack +
                '}';
    }
}
