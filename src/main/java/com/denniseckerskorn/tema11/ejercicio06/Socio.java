package com.denniseckerskorn.tema11.ejercicio06;

import java.time.LocalDate;
import java.time.Period;

public class Socio {
    private final String nif;
    private final String nombre;
    private final LocalDate fechaNacimiento;
    private final String poblacion;
    private final int edad;

    public Socio(String nif, String nombre, LocalDate fechaNacimiento, String poblacion) throws IllegalArgumentException {
        this.nif = nif;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.poblacion = poblacion;
        this.edad = getEdadSocio();
        if (edad < 18) {
            throw new IllegalArgumentException("El socio no puede ser menor de edad");
        }
    }

    private int getEdadSocio() {
        LocalDate now = LocalDate.now();
        Period period = Period.between(fechaNacimiento, now);
        return period.getYears();
    }
}
