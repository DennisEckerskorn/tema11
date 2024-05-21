package com.denniseckerskorn.tema11.ejercicio03;

/**
 * Classe que representa un coche.
 */
public class Coche {
    private static int totalMarchas = 6;
    private final String matricula;
    private final int velocidad;
    private final int marcha;
    private int[] marchas;

    /**
     * Constructor que inicializa los valores iniciales a los parámetros del constructor.
     *
     * @param matricula Matricula del coche
     */
    public Coche(String matricula) {
        this.matricula = matricula;
        this.velocidad = 0; // 0 equivale a parado
        this.marcha = 0; // Neutro
        marchas = new int[totalMarchas];
    }




}
