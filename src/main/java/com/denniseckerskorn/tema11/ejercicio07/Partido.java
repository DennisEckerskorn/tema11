package com.denniseckerskorn.tema11.ejercicio07;

import com.denniseckerskorn.tema11.ejercicio07.entradas.Entrada;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Partido {
    private static int nextID = 0;
    private final int id;
    private final String nombreEquipoLocal;
    private final String nombreEquipoVisitante;
    private TipoPartido tipoPartido;
    private Estadio estadios;
    private List<Entrada> entradas;
    private LocalDate fechaPartido;

    public Partido(String nombreEquipoLocal, String nombreEquipoVisitante, TipoPartido tipoPartido, Estadio estadio, String fechaPartido) throws DateTimeParseException {
        this.id = ++nextID;
        this.nombreEquipoLocal = nombreEquipoLocal;
        this.nombreEquipoVisitante = nombreEquipoVisitante;
        this.tipoPartido = tipoPartido;
        this.estadios = estadio;
        this.entradas = new ArrayList<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.fechaPartido = LocalDate.parse(fechaPartido, dtf);
    }

    public int getId() {
        return id;
    }

    public String getNombreEquipoLocal() {
        return nombreEquipoLocal;
    }

    public String getNombreEquipoVisitante() {
        return nombreEquipoVisitante;
    }

    public TipoPartido getTipoPartido() {
        return tipoPartido;
    }

    public Estadio getEstadios() {
        return estadios;
    }

    public LocalDate getFechaPartido() {
        return fechaPartido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Partido partido = (Partido) o;
        return id == partido.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "id=" + id +
                ", nombreEquipoLocal='" + nombreEquipoLocal + '\'' +
                ", nombreEquipoVisitante='" + nombreEquipoVisitante + '\'' +
                ", tipoPartido=" + tipoPartido +
                ", estadios=" + estadios +
                ", entradas=" + entradas +
                ", fechaPartido=" + fechaPartido +
                '}';
    }
}
