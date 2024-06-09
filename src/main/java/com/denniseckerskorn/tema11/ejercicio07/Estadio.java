package com.denniseckerskorn.tema11.ejercicio07;


import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Estadio {
    private static int nextID = 0;
    private final int id;
    private final String nombre;
    private final Map<TipoZona, Zona> mapZonas;
    private final List<Partido> partidos;

    public Estadio(String nombre) {
        this.id = ++nextID;
        this.nombre = nombre;
        this.mapZonas = new HashMap<>();
        this.partidos = new ArrayList<>();
    }

    public static int getNextID() {
        return nextID;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Map<TipoZona, Zona> getMapZonas() {
        return mapZonas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estadio estadio = (Estadio) o;
        return id == estadio.id && Objects.equals(nombre, estadio.nombre) && Objects.equals(mapZonas, estadio.mapZonas);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Objects.hashCode(nombre);
        result = 31 * result + Objects.hashCode(mapZonas);
        return result;
    }

    @Override
    public String toString() {
        return "Estadio{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", mapZonas=" + mapZonas +
                '}';
    }
}
