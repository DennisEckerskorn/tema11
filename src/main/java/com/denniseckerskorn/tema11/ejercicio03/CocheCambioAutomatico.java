package com.denniseckerskorn.tema11.ejercicio03;

public class CocheCambioAutomatico extends Coche {

    /**
     * Constructor que inicializa los valores iniciales del coche.
     *
     * @param matricula La matrícula del coche.
     */
    public CocheCambioAutomatico(String matricula) {
        super(matricula);
    }

    /**
     * Llama al método de la clase padre Coche.acelerar() y aumenta la aceleración.
     * Cuando se aumenta la velocidad se cambia la marcha automáticamente.
     *
     * @param aceleracion el valor de la aceleración, debe ser mayor que cero para aumentar la velocidad.
     */
    @Override
    public void acelerar(float aceleracion) {
        super.acelerar(aceleracion);
        cambiarMarchaAutomaticamente();
    }

    /**
     * Llama al método de la clase padre Coche.frenar() y disminuye la velocidad mediante la frenada.
     * Conforme va cambiando la velocidad, se va cambiando la marcha con el método cambiarMarchaAutomaticamente().
     *
     * @param frenada el valor de la frenada, debe ser mayor que cero para reducir la velocidad.
     */
    @Override
    public void frenar(float frenada) {
        super.frenar(frenada);
        cambiarMarchaAutomaticamente();
    }

    /**
     * Método privado que cambia de marcha automáticamente según la velocidad actual del coche.
     * Se obtiene la velocidad actual y las marchas. Mediante un bucle se recorren las marchas,
     * si la velocidad es menor o igual al valor de la marcha se cambia de marcha.
     * Finalmente se asigna la nueva marcha.
     */
    private void cambiarMarchaAutomaticamente() {
        int nuevaMarcha = 0;
        float velocidadActual = getVelocidad();
        int[] marchas = getMarchas();

        for (int i = 0; i < marchas.length; i++) {
            if (velocidadActual <= marchas[i]) {
                nuevaMarcha = i;
                break;
            }
        }
        cambiarMarcha(nuevaMarcha);
    }
}
