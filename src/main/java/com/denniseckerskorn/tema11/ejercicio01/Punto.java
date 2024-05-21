package com.denniseckerskorn.tema11.ejercicio01;

/**
 * Classe Punto que representa dos puntos x, y.
 */
public class Punto {
    private final double x;
    private final double y;

    /**
     * Constructor sin parámetros, inicializa x, y en 0
     */
    public Punto() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Constructor que recibe dos parámetros x, y e inicializa los attributos de la clase en estos valores
     *
     * @param x double coordenada x del punto.
     * @param y double coordenada y del punto.
     */
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Calcula la distancia entre este punto y otro punto dado.
     *
     * @param punto Punto con x, y para calcular la distancia
     * @return la distancia entre puntos x, y
     */
    public double distancia(Punto punto) {
        double distanciaX = this.x - punto.x;
        double distanciaY = this.y - punto.y;
        return Math.sqrt(distanciaX * distanciaX + distanciaY * distanciaY);
    }

    /**
     * Getter para obtener el punto x.
     *
     * @return coordenada x del punto
     */
    public double getX() {
        return x;
    }

    /**
     * Getter para obtener el punto y.
     *
     * @return coordenada y del punto
     */
    public double getY() {
        return y;
    }

    /**
     * Método toString que muestra x, y en formato (x,y).
     *
     * @return Cadena con formato (x, y)
     */
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
