package com.denniseckerskorn.tema11.ejercicio05.gameobjects;

/**
 * Clase que representa un Pico hereda de GameObjects
 */
public class Pico extends GameObject {

    /**
     * Constructor por defecto.
     * No es apilable.
     */
    public Pico() {
        super("Pico", false, 1);
    }
}
