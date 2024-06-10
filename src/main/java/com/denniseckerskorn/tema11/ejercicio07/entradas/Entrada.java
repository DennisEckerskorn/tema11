package com.denniseckerskorn.tema11.ejercicio07.entradas;

import com.denniseckerskorn.tema11.ejercicio07.*;

import java.util.Enumeration;
import java.util.Random;

public abstract class Entrada {
    private static int nextID = 0;
    private final int id;
    private Partido partido;
    private Zona zona;
    private double precioFinalEntrada;
    private int fila;
    private int asiento;
    private Random random;

    public Entrada(Partido partido, Zona zona, int fila, int asiento) throws IllegalArgumentException {
        this.id = ++nextID;
        this.partido = partido;
        this.zona = zona;
        this.fila = fila;
        this.asiento = asiento;
        this.precioFinalEntrada = zona.calcularPrecioFinal(partido.getTipoPartido());
        this.random = new Random();

        if(!zona.marcarAsientoOcupado(fila, asiento)) {
            throw new IllegalArgumentException("El asiento " + asiento + " en la fila " + fila + " ya está ocupado o no existe");
        }
    }

    public int getId() {
        return id;
    }

    public Partido getPartido() {
        return partido;
    }

    public Zona getZona() {
        return zona;
    }

    public double getPrecioFinalEntrada() {
        return precioFinalEntrada;
    }

    public int getFila() {
        return fila;
    }

    public int getAsiento() {
        return asiento;
    }

    public Random getRandom() {
        return random;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entrada entrada = (Entrada) o;
        return id == entrada.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Entrada{" +
                "id=" + id +
                ", partido=" + partido +
                ", zona=" + zona +
                ", precioFinalEntrada=" + precioFinalEntrada +
                ", fila=" + fila +
                ", asiento=" + asiento +
                '}';
    }

}
