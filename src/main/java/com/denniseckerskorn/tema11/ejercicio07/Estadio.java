package com.denniseckerskorn.tema11.ejercicio07;


import com.denniseckerskorn.tema11.ejercicio07.entradas.Entrada;
import com.denniseckerskorn.tema11.ejercicio07.entradas.EntradaNormal;

import java.time.format.DateTimeParseException;
import java.util.*;

public class Estadio {
    private final static int DEFAULT_ZONAS_NORMALES = 10;
    private final static int DEFAULT_ZONAS_VIP = 10;
    private final static int DEFAULT_PARTIDOS = 3;
    private static int nextID = 0;
    private final int id;
    private final String nombre;
    private final Map<Integer, Zona> mapZonas; //Usar zoneID para la clave
    private final List<Partido> partidos;

    public Estadio(String nombre) {
        this.id = ++nextID;
        this.nombre = nombre;
        this.mapZonas = new HashMap<>();
        this.partidos = new ArrayList<>();

        generateZonas(DEFAULT_ZONAS_NORMALES, TipoZona.ZONA_NORMAL, 10.00);
        generateZonas(DEFAULT_ZONAS_VIP, TipoZona.ZONA_VIP, 20.00);
        generatePartidos("Javea", "Denia", TipoPartido.ALTA_AFLUENCIA, "01/01/2020");
        generatePartidos("Valencia", "Alicante", TipoPartido.ALTA_AFLUENCIA, "02/02/2022");

        for (Partido partido : partidos) {
            generateEntradas(partido, 100);
        }

    }

    private void generateEntradas(Partido partido, int numEntradas) {
        List<Entrada> entradas = new ArrayList<>();
        for (int i = 0; i < numEntradas; i++) {
            Zona zona = getRandomZona();
            int fila = zona.getRandomFila();
            int asiento = zona.getRandomAsiento(fila);
            try {
                Entrada entrada = new EntradaNormal(partido, zona, fila, asiento);
                partido.addEntrada(entrada);
            } catch (IllegalArgumentException iae) {
                System.err.println(iae.getMessage());
            }
        }
    }

    private Zona getRandomZona() {
        List<Zona> zonas = new ArrayList<>(mapZonas.values());
        return zonas.get(new Random().nextInt(zonas.size()));
    }

    private void generateZonas(int defaultNum, TipoZona tipoZona, double precioBase) {
        for (int i = 0; i < defaultNum; i++) {
            Zona zona = new Zona(tipoZona, precioBase);
            mapZonas.put(zona.getZoneID(), zona);
        }
    }

    private void generatePartidos(String nombreLocal, String nombreVisit, TipoPartido tipoPartido, String fechaPartido) {
        try {
            //for(int i = 0; i < numPartidos; i++) {
            Partido partido = new Partido(nombreLocal, nombreVisit, tipoPartido, fechaPartido);
            partidos.add(partido);
            // }
        } catch (DateTimeParseException dtpe) {
            dtpe.getMessage();
        }
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

    public Map<Integer, Zona> getMapZonas() {
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
                ", partidos=" + partidos +
                '}';
    }
}
