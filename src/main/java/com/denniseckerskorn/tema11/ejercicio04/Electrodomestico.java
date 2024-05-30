package com.denniseckerskorn.tema11.ejercicio04;

import java.util.Objects;

public class Electrodomestico implements Priceable {
    public enum Color {BLANCO, NEGRO, GRIS, AZUL, ROJO}

    public enum ConsumoEnergetico {A, B, C, D, E, F}


    private static final Color COLOR_INICIAL = Color.BLANCO;
    private static final ConsumoEnergetico CONSUMO_INICIAL = ConsumoEnergetico.F;
    private static final float PRECIO_INICIAL = 100;
    private static final float PESO_INICIAL = 5;

    private Color color;
    private ConsumoEnergetico consumoEnergetico;
    private float precioBase;
    private float peso;

    /**
     * Constructor con todos los parametros.
     * Revisa si las letras iniciadas son correctas, si no, los cambia al valor incial.
     *
     * @param color      String color del electrodomestico
     * @param consumo    char consumo energético del electrodomestico
     * @param precioBase float precio del electrodomestico
     * @param peso       float precio del electrodomestico
     */
    public Electrodomestico(String color, char consumo, float precioBase, float peso) {
        if (!comprobarColor(color)) {
            this.color = COLOR_INICIAL;
        }
        if (!comprobarConsumoEnergetico(consumo)) {
            this.consumoEnergetico = CONSUMO_INICIAL;
        }
        this.precioBase = precioBase;
        this.peso = peso;

    }

    /**
     * Constructor precio y peso
     *
     * @param precioBase
     * @param peso
     */
    public Electrodomestico(float precioBase, float peso) {
        this.color = COLOR_INICIAL;
        this.consumoEnergetico = CONSUMO_INICIAL;
        this.precioBase = precioBase;
        this.peso = peso;
    }

    /**
     * Constructor por defecto
     */
    public Electrodomestico() {
        this(COLOR_INICIAL.toString(), CONSUMO_INICIAL.toString().charAt(0), PRECIO_INICIAL, PESO_INICIAL);

    }

    public Color getColor() {
        return color;
    }

    public ConsumoEnergetico getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public float getPrecioBase() {
        return precioBase;
    }

    public float getPeso() {
        return peso;
    }

    /**
     * Comprueba si la letra del consumo energético es válida.
     *
     * @param letra la letra que representa el consumo energético.
     * @return true si la letra es válida y se asigna correctamente, false de lo contrario.
     */
    private boolean comprobarConsumoEnergetico(char letra) {
        try {
            this.consumoEnergetico = ConsumoEnergetico.valueOf(String.valueOf(letra).toUpperCase());
            return true;
        } catch (
                IllegalArgumentException iae) {
            return false;
        }
    }

    /**
     * Comprueba si el color es válido.
     *
     * @param color el nombre del color.
     * @return true si el color es válido y se asigna correctamente, false de lo contrario.
     */
    private boolean comprobarColor(String color) {
        try {
            this.color = Color.valueOf(String.valueOf(color).toUpperCase());
            return true;
        } catch (IllegalArgumentException iae) {
            return false;
        }
    }

    @Override
    public double precioFinal() {
        double resultadoFinal = this.precioBase;

        switch (this.consumoEnergetico) {
            case A:
                resultadoFinal += 100;
                break;
            case B:
                resultadoFinal += 80;
                break;
            case C:
                resultadoFinal += 60;
                break;
            case D:
                resultadoFinal += 50;
                break;
            case E:
                resultadoFinal += 30;
                break;
            case F:
                resultadoFinal += 10;
                break;
        }

        if (this.peso >= 0 && this.peso <= 19) {
            resultadoFinal += 10;
        } else if (this.peso >= 20 && this.peso <= 49) {
            resultadoFinal += 50;
        } else if (this.peso >= 50 && this.peso <= 79) {
            resultadoFinal += 80;
        } else {
            resultadoFinal += 100;
        }

        return resultadoFinal;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Electrodomestico that = (Electrodomestico) o;
        return Float.compare(precioBase, that.precioBase) == 0 && Float.compare(peso, that.peso) == 0 && color == that.color && consumoEnergetico == that.consumoEnergetico;
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(color);
        result = 31 * result + Objects.hashCode(consumoEnergetico);
        result = 31 * result + Float.hashCode(precioBase);
        result = 31 * result + Float.hashCode(peso);
        return result;
    }

    @Override
    public String toString() {
        return "Electrodomestico{" +
                "color=" + color +
                ", consumoEnergetico=" + consumoEnergetico +
                ", precioBase=" + precioBase +
                ", peso=" + peso +
                '}';
    }
}
