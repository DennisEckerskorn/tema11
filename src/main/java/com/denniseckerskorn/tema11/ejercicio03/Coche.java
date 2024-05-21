package com.denniseckerskorn.tema11.ejercicio03;

/**
 * Classe que representa un coche.
 */
public class Coche {
    private static int totalMarchas = 6;
    private final String matricula;
    private float velocidad;
    private int marcha;
    private int[] marchas;

    /**
     * Constructor que inicializa los valores iniciales a los parámetros del constructor.
     *
     * @param matricula Matricula del coche
     */
    public Coche(String matricula) {
        this.matricula = matricula;
        this.velocidad = 0f; // 0 equivale a parado
        this.marcha = 0; // Neutro
        marchas = new int[totalMarchas];
    }

    public String getMatricula() {
        return matricula;
    }

    public float getVelocidad() {
        return velocidad;
    }

    public int getMarcha() {
        return marcha;
    }

    public void acelerar(float aceleracion) {
        if(aceleracion <= 0) {
            velocidad = 0;
        }
        velocidad += aceleracion;
    }

    public void frenar(float frenada) {

    }

    protected void setMarcha(int cambioMarcha) {
        if(cambioMarcha <= 0) {
            marcha = 0;
        }
        marcha = cambioMarcha;
    }
}
