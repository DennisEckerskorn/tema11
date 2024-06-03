package com.denniseckerskorn.tema11.ejercicio05.gameobjects;

/**
 * Clase que representa una Piedra, hereda de GameObjects
 */
public class Piedra extends GameObject {

    /**
     * Constructor por defecto
     * Es apilable, max 64
     */
    public Piedra() {
        super("Piedra", true, 64);
    }
}
