package com.denniseckerskorn.tema11.ejercicio03;

import java.util.Arrays;

/**
 * Classe que representa un coche.
 */
public class Coche {
    private static final int TOTAL_MARCHAS = 6;
    private final String matricula;
    private float velocidad;
    private int marcha;
    private int[] marchas;

    /**
     * Constructor que inicializa los valores iniciales del coche.
     *
     * @param matricula La matrícula del coche.
     */
    public Coche(String matricula) {
        this.matricula = matricula;
        this.velocidad = 0f; // 0 equivale a parado
        this.marcha = 0; // Neutro
        marchas = new int[]{0, 20, 40, 60, 90, 120, 150};
    }

    /**
     * Getter para obtener la matricula del coche.
     *
     * @return
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Getter para obtener la velocidad del coche.
     *
     * @return
     */
    public float getVelocidad() {
        return velocidad;
    }

    /**
     * Getter para obtener la marcha del coche.
     *
     * @return
     */
    public int getMarcha() {
        return marcha;
    }

    /**
     * Getter para obtener las marchas del array.
     *
     * @return
     */
    public int[] getMarchas() {
        return marchas;
    }

    /**
     * Aumenta la velocidad del coche en respuesta a una aceleración.
     * Si el valor de la aceleración es menor o igual a cero, se establece la velocidad en cero,
     * ya que el coche no puede acelerar hacia atrás ni mantener una velocidad negativa.
     * De lo contrario, se incrementa la velocidad actual del coche en la cantidad especificada por el valor de la aceleración.
     *
     * @param aceleracion el valor de la aceleración, debe ser mayor que cero para aumentar la velocidad.
     **/
    public void acelerar(float aceleracion) {
        if (aceleracion <= 0) {
            velocidad = 0;
        } else {
            velocidad += aceleracion;
        }
    }

    /**
     * Reduce la velocidad del coche en respuesta a una frenada.
     * Si el valor de la frenada es menor o igual a cero, la función no hace nada.
     * De lo contrario, reduce la velocidad del coche en la cantidad especificada por el valor de la frenada.
     * Si la velocidad resultante es menor que cero, se establece en cero para evitar velocidades negativas.
     *
     * @param frenada el valor de la frenada, debe ser mayor que cero para reducir la velocidad.
     */
    public void frenar(float frenada) {
        if (frenada <= 0) {
            return;
        }
        velocidad -= frenada;

        if (velocidad < 0) {
            velocidad = 0;
        }
    }

    /**
     * Cambia la marcha del coche a la marcha especificada.
     * Si la marcha especificada es menor que 0, se establece en la marcha neutra (0).
     * Si la marcha especificada es mayor o igual al total de marchas disponibles, se establece en la marcha máxima.
     *
     * @param cambioMarcha La nueva marcha a la que se cambiará.
     */
    protected void cambiarMarcha(int cambioMarcha) {
        if (cambioMarcha < 0) {
            marcha = 0;
        } else if (cambioMarcha >= TOTAL_MARCHAS) {
            marcha = TOTAL_MARCHAS;
        } else {
            marcha = cambioMarcha;
        }
    }

    @Override
    public String toString() {
        return "Coche{" +
                "matricula='" + matricula + '\'' +
                ", velocidad=" + velocidad +
                ", marcha=" + marcha +
                '}';
    }
}
