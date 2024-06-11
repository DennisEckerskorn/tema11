package com.denniseckerskorn.tema11.ejercicio07;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Zona {
    private final static int DEFAULT_FILAS = 10;
    private static int nextID = 0;
    private final int zoneID;
    private final List<Fila> filas;
    private TipoZona tipoZona;
    private double precioBase;

    public Zona(TipoZona tipoZona, double precioBase) {
        this.zoneID = ++nextID;
        this.filas = new ArrayList<>(DEFAULT_FILAS);
        this.tipoZona = tipoZona;
        this.precioBase = precioBase;

        for (int i = 1; i <= DEFAULT_FILAS; i++) {
            filas.add(new Fila(i));
        }
    }

    public boolean addFila(int numFila) {
        Fila fila = new Fila(numFila);
        for (int i = 0; i < filas.size(); i++) {
            if (filas.get(i).getNumFila() == numFila) {
                return false;
            }
        }
        return filas.add(fila);
    }

    public boolean marcarAsientoOcupado(int fila, int numeroAsiento) {
        if (fila >= 1 && fila <= filas.size()) {
            return filas.get(fila - 1).marcarAsientoOcupado(numeroAsiento);
        }
        return false;
    }

    public boolean marcarAsientoDisponible(int fila, int numeroAsiento) {
        if (fila >= 1 && fila <= filas.size()) {
            return filas.get(fila - 1).marcarAsientoLibre(numeroAsiento);
        }
        return false;
    }

    public double calcularPrecioFinal(TipoPartido tipoPartido) throws IllegalArgumentException {
        switch (tipoPartido) {
            case BAJA_AFLUENCIA:
                return precioBase * 0.75;
            case MEDIA_AFLUENCIA:
                return precioBase;
            case ALTA_AFLUENCIA:
                return precioBase * 1.30;
            default:
                throw new IllegalArgumentException("No es un tipo de partido váldio" + tipoPartido);
        }
    }

    public int getRandomFila() {
        return new Random().nextInt(filas.size());
    }

    public int getRandomAsiento(int filaIndex) throws IllegalArgumentException {
        if (filaIndex >= 0 && filaIndex < filas.size()) {
            Fila fila = filas.get(filaIndex);
            return fila.getRandomAsiento();
        } else {
            throw new IllegalArgumentException("Invalid row index: " + filaIndex);
        }
    }

    public static int getNextID() {
        return nextID;
    }

    public int getZoneID() {
        return zoneID;
    }

    public List<Fila> getFilas() {
        return filas;
    }

    public TipoZona getTipoZona() {
        return tipoZona;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public int getTotalAsientos() {
        int totalAsientos = 0;
        for (Fila fila : filas) {
            totalAsientos += fila.getNumeroAsientos();
        }
        return totalAsientos;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Zona zona = (Zona) o;
        return zoneID == zona.zoneID;
    }

    @Override
    public int hashCode() {
        return zoneID;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ZONE ID = ").append(zoneID).append("\n");
        sb.append("TIPO ZONA = ").append(tipoZona).append("\n");
        sb.append(filas);
        return sb.toString();
    }
}

