package com.denniseckerskorn.tema11.ejercicio07.entradas;

import com.denniseckerskorn.tema11.ejercicio07.Asiento;
import com.denniseckerskorn.tema11.ejercicio07.Fila;
import com.denniseckerskorn.tema11.ejercicio07.TipoPartido;
import com.denniseckerskorn.tema11.ejercicio07.Zona;

import java.util.Enumeration;

public abstract class Entrada {
    private static int nextID = 0;
    private final int id;
    private TipoPartido tipoPartido;
    private Zona zona;
    private double precioFinalEntrada;
    private int fila;
    private int asiento;

    public Entrada(TipoPartido tipoPartido, Zona zona, int fila, int asiento) throws IllegalArgumentException {
        this.id = ++nextID;
        this.tipoPartido = tipoPartido;
        this.zona = zona;
        this.fila = fila;
        this.asiento = asiento;
        this.precioFinalEntrada = zona.calcularPrecioFinal(tipoPartido);

        if(!zona.marcarAsientoOcupado(fila, asiento)) {
            throw new IllegalArgumentException("El asiento " + asiento + " en la fila " + fila + " ya está ocupado o no existe");
        }
    }

    public int getId() {
        return id;
    }

    public TipoPartido getTipoPartido() {
        return tipoPartido;
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
                ", tipoPartido=" + tipoPartido +
                ", zona=" + zona +
                ", precioFinalEntrada=" + precioFinalEntrada +
                ", fila=" + fila +
                ", asiento=" + asiento +
                '}';
    }
}
