package com.denniseckerskorn.tema11.ejercicio04;

public class Lavadora extends Electrodomestico {
    public static final float CARGA_INICIAL = 5;
    private final float carga;

    public Lavadora(String color, char consumo, float precioBase, float peso, float carga) {
        super(color, consumo, precioBase, peso);
        this.carga = carga;
    }

    public Lavadora(float precio, float peso) {
        super(precio, peso);
        this.carga = CARGA_INICIAL;
    }

    /**
     * Constructor por defecto
     */
    public Lavadora() {
        super();
        this.carga = CARGA_INICIAL;
    }


    @Override
    public double precioFinal() {
        double resultado = super.precioFinal();

        return resultado;
    }
}