package com.denniseckerskorn.tema11.ejercicio03;

import com.denniseckerskorn.lib.LibIO;

public class App {
    public App() {
        solicitarDatosCoche();
    }

    /**
     * Método que se encarga de pedir datos e invocar los métodos de creación y manipulación de coches.
     */
    private void solicitarDatosCoche() {
        int opcion = -1;
        do {
            String matricula = LibIO.requestString("Introduce la matrícula del coche:", 7, 7);
            System.out.println("1. Manual ...");
            System.out.println("2. Automático ...");
            System.out.println("0. Salir ...");
            opcion = LibIO.requestInt("El coche es manual o automático?");

            switch (opcion) {
                case 1:
                    Coche cocheManual = crearCocheManual(matricula);
                    System.out.println(cocheManual);
                    break;
                case 2:
                    Coche cocheAutomatico = crearCocheAutomatico(matricula);
                    System.out.println(cocheAutomatico);
                    break;
                case 0:
                    System.out.println("Hasta Pronto...");
                    break;
                default:
                    System.out.println("Número no válido");
            }
        } while (opcion != 0);
    }

    /**
     * Crea un coche manual y obtiene datos de velocidad y marcha del usuario.
     * Como prueba, cambia la marcha a la sexta después de la entrada del usuario.
     *
     * @param matricula La matrícula del coche que se va a crear.
     * @return Coche manual creado.
     */
    private Coche crearCocheManual(String matricula) {
        Coche cocheManual = new CocheCambioManual(matricula);
        float velocidadM = LibIO.requestFloat("A qué velocidad quieres que vaya el coche?", 0f, 160f);
        int marcha = LibIO.requestInt("Mete la marcha:", 0, 6);
        moverCocheManual(cocheManual, velocidadM, marcha);
        cocheManual.cambiarMarcha(6);
        return cocheManual;
    }

    /**
     * Método que se usa para mover el coche manual, permitiendo ajustar la velocidad y la marcha del coche.
     *
     * @param cocheManual El objeto del coche manual creado.
     * @param velocidad   El valor de aceleración del coche.
     * @param marcha      La marcha del coche.
     */
    private void moverCocheManual(Coche cocheManual, float velocidad, int marcha) {
        cocheManual.acelerar(velocidad);
        cocheManual.cambiarMarcha(marcha);
        System.out.println(cocheManual);
    }

    /**
     * Método que se encarga de crear un coche automático y solicita la velocidad al usuario.
     * La marcha se cambia automáticamente al subir o bajar la velocidad.
     *
     * @param matricula La matrícula del coche que se va a crear.
     * @return Coche automático creado.
     */
    private Coche crearCocheAutomatico(String matricula) {
        Coche cocheAutomatico = new CocheCambioAutomatico(matricula);
        float velocidadA = LibIO.requestFloat("A qué velocidad quieres que vaya el coche?", 0f, 160f);
        cocheAutomatico.acelerar(velocidadA);
        return cocheAutomatico;
    }
}
