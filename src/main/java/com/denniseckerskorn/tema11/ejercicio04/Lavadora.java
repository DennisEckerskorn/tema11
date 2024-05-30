package com.denniseckerskorn.tema11.ejercicio04;

public class Lavadora extends Electrodomestico {
    //public static final float CARGA_INICIAL = 5;
    private final float carga;

    /**
     * Constructor con todos los parámetros de la lavadora.
     *
     * @param color      String color de la lavadora
     * @param consumo    char consumo energético
     * @param precioBase float precio base
     * @param peso       float peso
     * @param carga      float carga
     */
    public Lavadora(String color, char consumo, float precioBase, float peso, float carga) {
        super(color, consumo, precioBase, peso);
        this.carga = carga;
    }

    /**
     * Constructor que recibe el precio y el peso.
     *
     * @param precio precioBase de la lavadora
     * @param peso   peso de la lavadora
     */
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

    public float getCarga() {
        return carga;
    }

    /**
     * Obtieneel resultado del método de la clase padre.
     * Si la carga es mayor o igual que 30 se añaden 50€ al precioFinal.
     *
     * @return el resultado calculado del precio final de la lavadora.
     */
    @Override
    public double precioFinal() {
        double resultado = super.precioFinal();
        if (this.carga >= 30) {
            resultado += 50;
        }
        return resultado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Lavadora lavadora = (Lavadora) o;
        return Float.compare(carga, lavadora.carga) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Float.hashCode(carga);
        return result;
    }

    @Override
    public String toString() {
        return "Lavadora{" +
                "carga=" + carga +
                '}';
    }
}