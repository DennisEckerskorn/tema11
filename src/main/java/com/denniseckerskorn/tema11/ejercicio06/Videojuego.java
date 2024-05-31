package com.denniseckerskorn.tema11.ejercicio06;

import java.util.Objects;

public class Videojuego extends Multimedia {
    private final Plataforma plataforma;

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
