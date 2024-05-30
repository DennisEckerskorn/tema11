package com.denniseckerskorn.tema11.ejercicio04;

public class Television extends Electrodomestico {

    private final float resolucion;
    private final boolean smartTV;

    /**
     * Constructor por defecto.
     */
    public Television() {
        super();
        this.resolucion = RESOLUCION_INICIAL;
        this.smartTV = SMARTTV_INICIAL;
    }

    /**
     * Constructor que recibe el precio y el peso por parámetro, el resto se inicia por defecto.
     *
     * @param precio float
     * @param peso   float
     */
    public Television(float precio, float peso) {
        super(precio, peso);
        this.resolucion = RESOLUCION_INICIAL;
        this.smartTV = SMARTTV_INICIAL;
    }

    /**
     * Constructor con todos los parámetros.
     *
     * @param color      String
     * @param consumo    char
     * @param precio     float
     * @param peso       float
     * @param resolucion float
     * @param smartTV    boolean
     */
    public Television(String color, char consumo, float precio, float peso, float resolucion, boolean smartTV) {
        super(color, consumo, precio, peso);
        this.resolucion = resolucion;
        this.smartTV = smartTV;
    }

    /**
     * Obtiene la resolucion
     *
     * @return resolucion obtenida
     */
    public float getResolucion() {
        return resolucion;
    }

    /**
     * Obtiene true o false
     *
     * @return boolean obtenido
     */
    public boolean isSmartTV() {
        return smartTV;
    }

    /**
     * Implementa el método de la clase padre.
     * super devuelve un resultado, sobre este resultado y los valores de las propiedades,
     * se añade un 30% al precio final si la resolución es mayor o igual a 40,
     * y se aplica un incremento de precio de 50 si el televisor no es un Smart TV.
     *
     * @return el precio final ajustado según las características del televisor.
     */
    @Override
    public double precioFinal() {
        double resultado = super.precioFinal();
        if (this.resolucion >= 40) {
            resultado += resultado * 0.3;
        }
        if (!this.smartTV) {
            resultado += 50;
        }
        return resultado;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Television that = (Television) o;
        return Float.compare(resolucion, that.resolucion) == 0 && smartTV == that.smartTV;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Float.hashCode(resolucion);
        result = 31 * result + Boolean.hashCode(smartTV);
        return result;
    }

    @Override
    public String toString() {
        return "Television{" +
                "resolucion=" + resolucion +
                ", smartTV=" + smartTV +
                '}' + "\n";
    }
}
