package com.denniseckerskorn.tema11.ejercicio06.multimedia;

import com.denniseckerskorn.tema11.ejercicio06.Formato;

import java.util.Objects;

/**
 * Clase que representa una película, hereda de la clase Multimedia.
 */
public class Pelicula extends Multimedia {
    private final float duracion;
    private final String actor;
    private final String actriz;

    /**
     * Constructor que inicializa una nueva película.
     *
     * @param titulo   El título de la película.
     * @param autor    El autor de la película.
     * @param anyo     El año de la película.
     * @param formato  El formato de la película.
     * @param duracion La duración de la película en minutos.
     * @param actor    El actor principal de la película.
     * @param actriz   La actriz principal de la película.
     */
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
