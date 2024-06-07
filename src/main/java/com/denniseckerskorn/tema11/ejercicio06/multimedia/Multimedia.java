package com.denniseckerskorn.tema11.ejercicio06.multimedia;

import com.denniseckerskorn.tema11.ejercicio06.Formato;

import java.util.Objects;

/**
 * Clase abstracta que representa un producto multimedia.
 */
public abstract class Multimedia {
    private String titulo;
    private String autor;
    private String anyo;
    private Formato formato;

    /**
     * Constructor de la clase Multimedia.
     *
     * @param titulo  El título del producto multimedia.
     * @param autor   El autor del producto multimedia.
     * @param anyo    El año de lanzamiento del producto multimedia.
     * @param formato El formato del producto multimedia.
     */
    public Multimedia(String titulo, String autor, String anyo, Formato formato) {
        this.titulo = titulo;
        this.autor = autor;
        this.anyo = anyo;
        this.formato = formato;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAnyo() {
        return anyo;
    }

    public void setAnyo(String anyo) {
        this.anyo = anyo;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Multimedia that = (Multimedia) o;
        return Objects.equals(titulo, that.titulo) && Objects.equals(autor, that.autor);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(titulo);
        result = 31 * result + Objects.hashCode(autor);
        return result;
    }

    @Override
    public String toString() {
        return "{Titulo = " + titulo + "\n" +
                "Autor = " + autor + "\n" +
                "Año = " + anyo + "\n" +
                "Formato = " + formato + "}\n";
    }
}
