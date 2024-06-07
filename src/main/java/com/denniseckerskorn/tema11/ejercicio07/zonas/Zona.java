package com.denniseckerskorn.tema11.ejercicio07.zonas;

import com.denniseckerskorn.tema11.ejercicio07.Asiento;

import javax.swing.*;
import java.util.*;

public abstract class Zona {
    private static final int DEFAULT_NUMFILAS = 10; //rows
    private static final int DEFAULT_NUM_ASIENTOS = 10; //cols
    private static int nextID = 0;
    private final int id;
    private final Map<String, Asiento> asientos;
    private final int numFilas;
    private final int numAsientos;

    /**
     * Constructor principal
     *
     * @param numFilas
     * @param numAsientos
     */
    public Zona(int numFilas, int numAsientos) {
        this.id = ++nextID;
        this.asientos = new HashMap<>();
        this.numFilas = numFilas;
        this.numAsientos = numAsientos;
        initializeSeatMatrix();
    }

    /**
     * Constructor por defecto
     */
    public Zona() {
        this(DEFAULT_NUMFILAS, DEFAULT_NUM_ASIENTOS);
    }

    /**
     * Permite generar la clave a partir de la posicion del asiento en la fila
     *
     * @param fila
     * @param asiento
     * @return String con la clave que se va a mapear.
     */
    public String generateKey(int fila, int asiento) {
        return fila + " - " + asiento;
    }

    /**
     * Inicializa la matriz de asientos dentro de un HashMap.
     * Cada Fila - Columna tiene un asiento, ejemplo Fila 1 - Columna 1 = Asiento 1
     * Cada Zona tiene las mismas filas y numero de asientos.
     */
    private void initializeSeatMatrix() {
        for (int i = 1; i <= numFilas; i++) {
            for (int j = 1; j <= numAsientos; j++) {
                String key = generateKey(i, j);
                asientos.put(key, new Asiento());
            }
        }
    }

    /**
     * Permite imprimir una matriz con las filas y sus asientos.
     * Permite ver el numero de Asiento y si esta ocupado o no.
     * @return String con la matriz de asientos libres o ocupados.
     */
    public String printSeatMatrix() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= numFilas; i++) {
            sb.append("Fila ").append(i).append(": ");
            for (int j = 1; j <= numAsientos; j++) {
                String key = generateKey(i, j);
                Asiento asiento = asientos.get(key);
                if (asiento != null) {
                    if (asiento.isOcupado()) {
                        sb.append(asiento);
                    } else {
                        sb.append(asiento);
                    }
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public boolean ocuparAsiento(int fila, int asiento) {
        String key = generateKey(fila, asiento);
        Asiento a = getAsientos().get(key);
        if(a != null && !a.isOcupado()){
            a.setOcupado(true);
            return true;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public Map<String, Asiento> getAsientos() {
        return asientos;
    }

    public int getNumFilas() {
        return numFilas;
    }

    public int getNumAsientos() {
        return numAsientos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Zona zona = (Zona) o;
        return id == zona.id && numFilas == zona.numFilas && Objects.equals(asientos, zona.asientos);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Objects.hashCode(asientos);
        result = 31 * result + numFilas;
        return result;
    }

    @Override
    public String toString() {
        return "Zona{" +
                "id=" + id +
                ", asientos=" + asientos +
                ", numFilas=" + numFilas +
                '}';
    }
}
