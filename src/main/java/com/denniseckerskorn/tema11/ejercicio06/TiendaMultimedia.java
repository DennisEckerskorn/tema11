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
        this.productosMultimedia = new TreeMap<>();
        this.socios = new HashMap();
        this.prestamos = new ArrayList<>();
        addPeliculasAuto(CANTIDAD_INICIAL);
        addVideojuegoAuto(CANTIDAD_INICIAL);
        addSociosAuto(CANTIDAD_INICIAL);

    }

    private void addPeliculasAuto(int cantidad) {
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

    private void addVideojuegoAuto(int cantidad) {
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

    private void addSociosAuto(int cantidad) {
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
     * Permite añdir una pelicula nueva a la lista de productos multimedia.
     *
     * @param titulo   String
     * @param autor    String
     * @param anyo     String
     * @param formato  enumerado
     * @param duracion float
     * @param actor    String
     * @param actriz   String
     * @return true si se ha podido crear la pelicula con éxito, false si no se ha podido.
     */
    public boolean addPelicula(String titulo, String autor, String anyo, Formato formato, float duracion, String actor, String actriz) {
        if (productosMultimedia != null) {
            Multimedia pelicula = new Pelicula(titulo, autor, anyo, formato, duracion, actor, actriz);
            productosMultimedia.put(titulo, pelicula);
            return true;
        }
        return false;
    }

    /**
     * Permite añadir un Videojuego nuevo a la lista de productos multimedia.
     *
     * @param titulo     String
     * @param autor      String
     * @param anyo       String
     * @param formato    enumerado
     * @param plataforma enumerado
     * @return true se ha añadido el objeto al la lista, false si no se ha podido.
     */
    public boolean addVideojuego(String titulo, String autor, String anyo, Formato formato, Plataforma plataforma) {
        if (productosMultimedia != null) {
            Multimedia videojuego = new Videojuego(titulo, autor, anyo, formato, plataforma);
            productosMultimedia.put(titulo, videojuego);
            return true;
        }
        return false;
    }

    /**
     * Obtiene un producto multimedia a partir del Titulo, ignora Mayuscula o Minuscula.
     *
     * @param titulo String Titulo de multimedia a buscar.
     * @return Multimedia con el titulo correspondiente o null si no existe.
     */
    public Multimedia obtenerMultimediaPorTitulo(String titulo) {
        for (Multimedia producto : productosMultimedia.values()) {
            if (producto.getTitulo().equalsIgnoreCase(titulo)) {
                return producto;
            }
        }
        return null;
    }

    /**
     * Permite añadir un nuevo socio al Map de Socios
     *
     * @param nif             String
     * @param nombre          String
     * @param fechaNacimiento LocalDate
     * @param poblacion       String
     * @return true se ha añadido correctamente a socios, false si no se ha podido añadir.
     */
    public boolean addSocio(String nif, String nombre, LocalDate fechaNacimiento, String poblacion) {
        if (socios != null) {
            Socio socio = new Socio(nif, nombre, fechaNacimiento, poblacion);
            socios.put(nif, socio);
            return true;
        }
        return false;
    }

    public Socio obtenerSocioPorNIF(String nif) {
        return socios.get(nif);
    }

    /**
     * Permite calcular el recargo pendiente de pagar del socio.
     * Si el Socio tiene varios prestamos se obtienen todos estos recargos.
     *
     * @return double el recargo pendiente de pagar.
     */
    public double calcularRecargosPendientes() {
        double recargosPendientes = 0;
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getRecargo() > 0) {
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
