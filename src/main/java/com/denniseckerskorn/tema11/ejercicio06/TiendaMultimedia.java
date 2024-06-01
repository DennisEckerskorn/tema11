package com.denniseckerskorn.tema11.ejercicio06;

import net.datafaker.Faker;

import java.time.LocalDate;
import java.util.*;

public class TiendaMultimedia {
    private static final int CANTIDAD_INICIAL = 10;
    private Map<String, Multimedia> productosMultimedia;
    private Map<String, Socio> socios;
    private List<Prestamo> prestamos;

    public TiendaMultimedia() {
        this.productosMultimedia = new HashMap();
        this.socios = new HashMap();
        this.prestamos = new ArrayList<>();
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
            productosMultimedia.put(titulo, pelicula);
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
            productosMultimedia.put(titulo, videojuego);
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
                socios.put(nif, socio);
            } catch (IllegalArgumentException iae) {
                System.err.println(iae.getMessage());
            }
        }
    }

    /**
     * Permite calcular el recargo pendiente de pagar del socio.
     * Si el Socio tiene varios prestamos se obtienen todos estos recargos.
     * @return double el recargo pendiente de pagar.
     */
    public double calcularRecargosPendientes() {
        double recargosPendientes = 0;
        for(Prestamo prestamo : prestamos) {
            if(prestamo.getRecargo() > 0) {
                recargosPendientes += prestamo.getRecargo();
            }
        }
        return recargosPendientes;
    }

    public Map<String, Multimedia> getProductosMultimedia() {
        return productosMultimedia;
    }

    public Map<String, Socio> getSocios() {
        return socios;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TiendaMultimedia that = (TiendaMultimedia) o;
        return productosMultimedia.equals(that.productosMultimedia) && socios.equals(that.socios);
    }

    @Override
    public int hashCode() {
        int result = productosMultimedia.hashCode();
        result = 31 * result + socios.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TiendaMultimedia{" +
                "productosMultimedia=" + productosMultimedia +
                ", socios=" + socios +
                ", prestamos=" + prestamos +
                '}';
    }
}
