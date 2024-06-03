package com.denniseckerskorn.tema11.ejercicio05.gameobjects;

/**
 * Clase que representa Madera, hereda de GameObject
 */
public class Madera extends GameObject {
    /**
     * Constructor por defecto.
     * Es apilable, max 64.
     */
    public Madera() {
        super("Madera", true, 64);
    }
}
