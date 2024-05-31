package com.denniseckerskorn.tema11.ejercicio06;

import java.util.Objects;

public class Pelicula extends Multimedia{
    private final float duracion;
    private final String actor;
    private final String actriz;


    public Pelicula(String titulo, String autor, String anyo, Formato formato, float duracion, String actor, String actriz) {
        super(titulo, autor, anyo, formato);
        this.duracion = duracion;
        this.actor = actor;
        this.actriz = actriz;
    }

    public float getDuracion() {
        return duracion;
    }

    public String getActor() {
        return actor;
    }

    public String getActriz() {
        return actriz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Pelicula pelicula = (Pelicula) o;
        return Float.compare(duracion, pelicula.duracion) == 0 && Objects.equals(actor, pelicula.actor) && Objects.equals(actriz, pelicula.actriz);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Float.hashCode(duracion);
        result = 31 * result + Objects.hashCode(actor);
        result = 31 * result + Objects.hashCode(actriz);
        return result;
    }

    //TODO: Adaptar bien
    @Override
    public String toString() {
        return super.toString() + "Pelicula{" +
                "duracion=" + duracion +
                ", actor='" + actor + '\'' +
                ", actriz='" + actriz + '\'' +
                '}';
    }
}
