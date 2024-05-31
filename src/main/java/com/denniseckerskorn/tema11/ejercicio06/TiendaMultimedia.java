package com.denniseckerskorn.tema11.ejercicio06;

import net.datafaker.Faker;

import java.time.LocalDate;
import java.util.*;

public class TiendaMultimedia {
    private static final int CANTIDAD_INICIAL = 10;
    private List<Multimedia> productosMultimedia;
    private List<Socio> socios;
    private Map<Socio, List<Prestamo>> prestamos;

    public TiendaMultimedia() {
        this.productosMultimedia = new ArrayList<>();
        this.socios = new ArrayList<>();
        this.prestamos = new HashMap<>();
        addPeliculas(CANTIDAD_INICIAL);
        addVideojuego(CANTIDAD_INICIAL);
        addSocios(CANTIDAD_INICIAL);

    }

    private void addPeliculas(int cantidad) {
        Faker faker = new Faker(new Locale("es", "ES"));
        for (int i = 0; i < cantidad; i++) {
            String titulo = faker.oscarMovie().movieName();
            String autor = faker.name().fullName();
            String anyo = faker.number().numberBetween(1980, 2023) + "";
            Formato formato = Formato.values()[faker.random().nextInt(Formato.values().length)];
            float duracion = 120.00f + faker.number().numberBetween(80, 140);
            String actor = faker.oscarMovie().actor();
            String actriz = faker.oscarMovie().actor();
            Multimedia pelicula = new Pelicula(titulo, autor, anyo, formato, duracion, actor, actriz);
            productosMultimedia.add(pelicula);
        }
    }

    private void addVideojuego(int cantidad) {
        Faker faker = new Faker(new Locale("es", "ES"));
        for (int i = 0; i < cantidad; i++) {
            String titulo = faker.oscarMovie().movieName();
            String autor = faker.name().fullName();
            String anyo = faker.number().numberBetween(1980, 2023) + "";
            Formato formato = Formato.values()[faker.random().nextInt(Formato.values().length)];
            Plataforma plataforma = Plataforma.values()[faker.random().nextInt(Formato.values().length)];
            Multimedia videojuego = new Videojuego(titulo, autor, anyo, formato, plataforma);
            productosMultimedia.add(videojuego);
        }
    }

    private void addSocios(int cantidad) {
        Faker faker = new Faker(new Locale("es", "ES"));
        for (int i = 0; i < cantidad; i++) {
            String nif = faker.idNumber().valid();
            String nombre = faker.name().fullName();
            LocalDate fechaNacimiento = LocalDate.of(
                    faker.number().numberBetween(1950, 2005),
                    faker.number().numberBetween(1, 12),
                    faker.number().numberBetween(1, 28)
            );
            String poblacion = faker.address().city();
            try {
                Socio socio = new Socio(nif, nombre, fechaNacimiento, poblacion);
                socios.add(socio);
            } catch (IllegalArgumentException iae) {
                iae.getMessage();
            }
        }
    }

    public Multimedia

    public Prestamo alquilarMultimedia() {

    }


    public List<Multimedia> getProductosMultimedia() {
        return productosMultimedia;
    }

    public List<Socio> getSocios() {
        return socios;
    }

    public Map<Socio, Multimedia> getAlquiler() {
        return alquiler;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TiendaMultimedia that = (TiendaMultimedia) o;
        return Objects.equals(productosMultimedia, that.productosMultimedia) && Objects.equals(socios, that.socios) && Objects.equals(alquiler, that.alquiler);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(productosMultimedia);
        result = 31 * result + Objects.hashCode(socios);
        result = 31 * result + Objects.hashCode(alquiler);
        return result;
    }

    @Override
    public String toString() {
        return "TiendaMultimedia: \n" + productosMultimedia + "\n" +
                "Socios: \n" + socios +
                "Alquileres: \n" + alquiler;

    }
}
