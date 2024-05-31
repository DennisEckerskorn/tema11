package com.denniseckerskorn.tema11.ejercicio06;

import java.time.LocalDate;

public class Prestamo {
    private static int nextID = 0;
    private final int id;
    private final Multimedia multimedia;
    private final LocalDate fechaInicio;
    private final LocalDate fechaDevolucion;
    private final int diasLimite;

    public Prestamo(Multimedia multimedia, LocalDate fechaInicio, LocalDate fechaDevolucion, int diasLimite) {
        this.id = ++nextID;
        this.multimedia = multimedia;
        this.fechaInicio = fechaInicio;
        this.fechaDevolucion = fechaDevolucion;
        this.diasLimite = diasLimite;
    }

    public Multimedia getMultimedia() {
        return multimedia;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public int getDiasLimite() {
        return diasLimite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Prestamo prestamo = (Prestamo) o;
        return id == prestamo.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "id=" + id +
                ", multimedia=" + multimedia +
                ", fechaInicio=" + fechaInicio +
                ", fechaDevolucion=" + fechaDevolucion +
                ", diasLimite=" + diasLimite +
                '}';
    }
}
