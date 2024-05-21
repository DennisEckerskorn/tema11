package com.denniseckerskorn.tema11.ejercicio03;

public class CocheCambioManual extends Coche {

    /**
     * Constructor que inicializa los valores iniciales del coche.
     *
     * @param matricula La matrícula del coche.
     */
    public CocheCambioManual(String matricula) {
        super(matricula);
    }

    /**
     * Valida que el valor del parámetro no sea negativo. Si el valor es negativo, no hace nada.
     * Llama al método de la clase Coche y sobreescribe el método haciéndolo público.
     *
     * @param cambioMarcha La nueva marcha a la que se cambiará.
     */
    @Override
    public void cambiarMarcha(int cambioMarcha) {
        if (cambioMarcha < 0) {
            return;
        }
        super.cambiarMarcha(cambioMarcha);
    }


}
