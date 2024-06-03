package com.denniseckerskorn.tema11.ejercicio05.gameobjects;

/**
 * Clase que representa una Espada, herede de GameObjects
 */
public class Espada extends GameObject {
    /**
     * Constructor por defecto.
     * No es apilable.
     **/
    public Espada() {
        super("Espada", false, 1);
    }
}
