package com.denniseckerskorn.tema11.ejercicio05.gameobjects;

/**
 * Constructor que representa un Huevo de Ender, hereda de GameObject
 */
public class PerlaEnder extends GameObject {
    /**
     * Constructor por defecto.
     * Es apilable, max 16.
     */
    public PerlaEnder() {
        super("Perla de Ender", true, 16);
    }
}
