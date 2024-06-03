package com.denniseckerskorn.tema11.ejercicio05.inventory;

import com.denniseckerskorn.tema11.ejercicio05.gameobjects.GameObject;

import java.util.Stack;

public class Slot {
    private final Stack<GameObject> gameObjects;
    private int maxStack;

    public Slot() {
        this.gameObjects = new Stack<>();
        this.maxStack = 0;
    }

    public boolean addObjectToStack(GameObject gameObject) {
        if (gameObjects.isEmpty()) {
            this.maxStack = gameObject.getMaxCantidad();
            if (gameObject.getMaxCantidad() == 1 && !gameObject.isApilable()) {
                return !gameObjects.contains(gameObject);
            } else {
                gameObjects.push(gameObject);
                return true;
            }
        } else if (gameObjects.size() < gameObject.getMaxCantidad()) {
            gameObjects.push(gameObject);
            return true;
        }
        return false;
    }

    public boolean removeObjectFromStack(GameObject gameObject) {
        if (!gameObjects.isEmpty()) {
            gameObjects.remove(gameObject);
            return true;
        }
        return false;
    }

    public Stack<GameObject> getGameObjects() {
        return gameObjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Slot slot = (Slot) o;
        return maxStack == slot.maxStack && gameObjects.equals(slot.gameObjects);
    }

    @Override
    public int hashCode() {
        int result = gameObjects.hashCode();
        result = 31 * result + maxStack;
        return result;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "gameObjects=" + gameObjects +
                '}';
    }
}
