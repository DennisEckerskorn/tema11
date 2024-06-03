package com.denniseckerskorn.tema11.ejercicio05.gameobjects;

/**
 * Clase que representa un Huevo, hereda de GameObject
 */
public class Huevo extends GameObject{
    /**
     * Constructor por defecto
     * Es apilable, max 16.
     */
    public Huevo() {
        super("Huevo", true, 16);
    }
}
