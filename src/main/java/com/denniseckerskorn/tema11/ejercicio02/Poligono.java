package com.denniseckerskorn.tema11.ejercicio02;

import com.denniseckerskorn.tema11.ejercicio01.Punto;

import java.util.List;

/**
 * Classe que representa un Poligono a partir de una lista de puntos (coordenadas).
 */
public class Poligono {
    private List<Punto> puntosPoligono;

    /**
     * Constructor que inicializa el polígono con una lista de puntos.
     *
     * @param puntos la lista de puntos que definen los vértices del polígono.
     */
    public Poligono(List<Punto> puntos) {
        this.puntosPoligono = puntos;
    }

    /**
     * Traslada todos los puntos del polígono por las cantidades dadas en las coordenadas x e y.
     *
     * @param desplazamientoX la cantidad a desplazar en el eje x.
     * @param desplazamientoY la cantidad a desplazar en el eje y.
     */
    public void traslada(double desplazamientoX, double desplazamientoY) {
        for (int i = 0; i < puntosPoligono.size(); i++) {
            Punto punto = puntosPoligono.get(i);
            double nuevoX = punto.getX() + desplazamientoX;
            double nuevoY = punto.getY() + desplazamientoY;
            puntosPoligono.set(i, new Punto(nuevoX, nuevoY));
        }
    }

    /**
     * Obtiene el número de vértices (puntos) que forman el polígono.
     *
     * @return el número de vértices del polígono.
     */
    public int numVertices() {
        return puntosPoligono.size();
    }

    /**
     * Calcula el perímetro del polígono sumando las distancias entre los puntos adyacentes.
     *
     * @return el perímetro del polígono.
     */
    public double perimetro() {
        double perimetro = 0;
        for (int i = 0; i < puntosPoligono.size(); i++) {
            Punto puntoActual = puntosPoligono.get(i);
            Punto puntoSiguiente = puntosPoligono.get((i + 1) % puntosPoligono.size());
            perimetro += puntoActual.distancia(puntoSiguiente);
        }
        return perimetro;
    }

    /**
     * Devuelve una representación en forma de cadena del polígono.
     *
     * @return una cadena que representa el polígono.
     */
    @Override
    public String toString() {
        return "Poligono{" +
                "puntosPoligono=" + puntosPoligono +
                '}';
    }
}
