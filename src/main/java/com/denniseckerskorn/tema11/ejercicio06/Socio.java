package com.denniseckerskorn.tema11.ejercicio06;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

/**
 * Clase que representa un socio en la tienda de multimedia.
 */
public class Socio {
    private List<Prestamo> prestamos;
    private final String nif;
    private final String nombre;
    private final LocalDate fechaNacimiento;
    private final String poblacion;
    private final int edad;
    private double recargosPendientes;

    /**
     * Constructor que inicializa un nuevo socio.
     *
     * @param nif             El NIF del socio.
     * @param nombre          El nombre del socio.
     * @param fechaNacimiento La fecha de nacimiento del socio.
     * @param poblacion       La población del socio.
     * @throws IllegalArgumentException si el socio es menor de edad.
     */
    public Socio(String nif, String nombre, LocalDate fechaNacimiento, String poblacion) throws IllegalArgumentException {
        this.prestamos = new ArrayList<>();
        this.nif = nif;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.poblacion = poblacion;
        this.edad = calcularEdad();
        this.recargosPendientes = 0;
        if (edad < 18) {
            throw new IllegalArgumentException("El socio no puede ser menor de edad");
        }
    }

    /**
     * Calcula la edad del socio basándose en su fecha de nacimiento.
     *
     * @return La edad del socio.
     */
    private int calcularEdad() {
        LocalDate now = LocalDate.now();
        return Period.between(fechaNacimiento, now).getYears();
    }

    public String getNif() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public int getEdad() {
        return edad;
    }

    public double getRecargosPendientes() {
        return recargosPendientes;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    /**
     * Permite establecer el total de recargos pendientes para el socio.
     *
     * @param recargosPendientes El total de recargos pendientes a establecer.
     */
    public void setRecargosPendientes(double recargosPendientes) {
        this.recargosPendientes = recargosPendientes;
    }

    /**
     * Calcula los recargos pendientes del socio sumando los recargos de todos sus préstamos.
     *
     * @return El total de recargos pendientes.
     */
    public double calcularRecargosPendientes() {
        double recargosPendiente = 0;
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getRecargo() > 0) {
                recargosPendiente += prestamo.getRecargo();
            }
        }
        return recargosPendiente;
    }

    /**
     * Añade un préstamo a la lista de préstamos del socio.
     *
     * @param prestamo El préstamo a añadir.
     * @return true si el préstamo se añadió correctamente, false en caso contrario.
     */
    public boolean addPrestamo(Prestamo prestamo) {
        return prestamos.add(prestamo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Socio socio = (Socio) o;
        return edad == socio.edad && nif.equals(socio.nif) && nombre.equals(socio.nombre) && fechaNacimiento.equals(socio.fechaNacimiento) && poblacion.equals(socio.poblacion);
    }

    @Override
    public int hashCode() {
        int result = nif.hashCode();
        result = 31 * result + nombre.hashCode();
        result = 31 * result + fechaNacimiento.hashCode();
        result = 31 * result + poblacion.hashCode();
        result = 31 * result + edad;
        return result;
    }

    @Override
    public String toString() {
        return "{NIF = " + nif + "\n" +
                "Nombre = " + nombre + "\n" +
                "Fecha Nacimiento = " + fechaNacimiento + "\n" +
                "Poblacion = " + poblacion + "\n" +
                "Edad = " + edad + "}\n";

    }
}
