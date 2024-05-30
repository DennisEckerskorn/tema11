package com.denniseckerskorn.tema11.ejercicio04;

public interface Priceable {
    //Constantes Electrodomestico:
    Electrodomestico.Color COLOR_INICIAL = Electrodomestico.Color.BLANCO;
    Electrodomestico.ConsumoEnergetico CONSUMO_INICIAL = Electrodomestico.ConsumoEnergetico.F;
    float PRECIO_INICIAL = 100;
    float PESO_INICIAL = 5;

    //Television:
    float RESOLUCION_INICIAL = 20;
    boolean SMARTTV_INICIAL = false;

    //Lavadora:
    float CARGA_INICIAL = 5;


    double precioFinal();
}
