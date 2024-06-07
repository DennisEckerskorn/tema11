package com.denniseckerskorn.tema11.ejercicio06.multimedia;

import com.denniseckerskorn.tema11.ejercicio06.Formato;
import com.denniseckerskorn.tema11.ejercicio06.Plataforma;

import java.util.Objects;

/**
 * Clase que representa un videojuego, que es un tipo de multimedia.
 */
public class Videojuego extends Multimedia {
    private final Plataforma plataforma;

    /**
     * Constructor de la clase Videojuego.
     *
     * @param titulo     El título del videojuego.
     * @param autor      El autor del videojuego.
     * @param anyo       El año de lanzamiento del videojuego.
     * @param formato    El formato del videojuego.
     * @param plataforma La plataforma en la que se juega el videojuego.
     */
    public Videojuego(String titulo, String autor, String anyo, Formato formato, Plataforma plataforma) {
        super(titulo, autor, anyo, formato);
        this.plataforma = plataforma;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Videojuego that = (Videojuego) o;
        return plataforma == that.plataforma;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(plataforma);
        return result;
    }

    //TODO: Adaptar
    @Override
    public String toString() {
        return super.toString() + "Videojuego{" +
                "plataforma=" + plataforma +
                '}';
    }
}
