package com.denniseckerskorn.tema11.ejercicio04;

import java.util.Objects;

public abstract class Electrodomestico implements Priceable {
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
     *
     * @param color             enum color del electrodomestico
     * @param consumoEnergetico enum consumo energético del electrodomestico
     * @param precioBase        float precio del electrodomestico
     * @param peso              float precio del electrodomestico
     */
    public Electrodomestico(Color color, ConsumoEnergetico consumoEnergetico, float precioBase, float peso) {
        this.color = color;
        this.consumoEnergetico = consumoEnergetico;
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
        this(Color.BLANCO, ConsumoEnergetico.F, PRECIO_INICIAL, PESO_INICIAL);
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

    @Override
    public abstract double precioFinal();

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
