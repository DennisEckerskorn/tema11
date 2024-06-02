package com.denniseckerskorn.tema11.ejercicio06;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestamo {
    private static final int DIAS_LIMITE = 3;
    private static double PRECIO_BASE = 4.0;
    private static final double RECARGO_POR_DIA = 2.0;
    private static final double DESCUENTO_PELICULA_ANTIGUA = 1.0;
    private static final double DESCUENTO_VIDEOJUEGO_ANTIGUO = 1.0;

    private static int nextID = 0;
    private final int id;
    private final Multimedia multimedia;
    private final Socio socio;
    private final LocalDate fechaInicio;
    private final LocalDate fechaDevolucion;
    private final int diasLimite;
    private final double recargo;
    private final double precioFinal;

    public Prestamo(Multimedia multimedia, Socio socio) {
        this.id = ++nextID;
        this.multimedia = multimedia;
        this.socio = socio;
        this.fechaInicio = LocalDate.now();
        this.fechaDevolucion = fechaInicio.plusDays(DIAS_LIMITE);
        this.diasLimite = DIAS_LIMITE;
        this.recargo = calcularRecargo();
        this.precioFinal = calcularPrecioFinalPrestamo();
    }

    /**
     * Permite calcular el recargo que tiene cada prestamo.
     * Primero se comprueban los dias que han pasado desde el prestamo hasta la fecha de devolucion.
     * Si el retraso es mayor que cero se obtiene el recargo a pagar.
     *
     * @return double recargo por el prestamo.
     */
    public double calcularRecargo() {
        long diasRetraso = ChronoUnit.DAYS.between(fechaDevolucion, LocalDate.now());
        if (diasRetraso > 0) {
            return diasRetraso * RECARGO_POR_DIA;
        } else {
            return 0;
        }
    }

    /**
     * Permite calcular el precio final del prestamo.
     * Si el producto multimedia es una Pelicula o un Videojuego y cumple la antiguedad,
     * se aplica un descuento a precio final.
     *
     * @return double la suma del precio obtenido y el recargo pendiente del prestamo.
     */
    private double calcularPrecioFinalPrestamo() {
        double precio = PRECIO_BASE;
        int anyo = Integer.parseInt(multimedia.getAnyo());

        if (multimedia instanceof Pelicula && anyo < 2012) {
            precio -= DESCUENTO_PELICULA_ANTIGUA;
        } else if (multimedia instanceof Videojuego && anyo < 2010) {
            precio -= DESCUENTO_VIDEOJUEGO_ANTIGUO;
        }
        return precio + recargo;
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

    public double getRecargo() {
        return recargo;
    }

    public static double getPrecioBase() {
        return PRECIO_BASE;
    }

    public int getId() {
        return id;
    }

    public double getPrecioFinal() {
        return precioFinal;
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
                ", socio=" + socio +
                ", fechaInicio=" + fechaInicio +
                ", fechaDevolucion=" + fechaDevolucion +
                ", diasLimite=" + diasLimite +
                ", recargo=" + recargo +
                ", precioFinal=" + precioFinal +
                '}';
    }
}
