package com.denniseckerskorn.tema11.ejercicio02;

import com.denniseckerskorn.tema11.ejercicio01.Punto;

import java.util.ArrayList;
import java.util.List;

public class InfoPuntoPoligono {
    public InfoPuntoPoligono() {
        // Crea la lista de puntos:
        List<Punto> puntos = new ArrayList<>();
        puntos.add(new Punto(0,0));
        puntos.add(new Punto(2,0));
        puntos.add(new Punto(2,2));
        puntos.add(new Punto(0,2));

        // Crea el poligono con la lista de puntos:
        Poligono poligono = new Poligono(puntos);

        // Imprime la información del polígono y su perímetro:
        System.out.println("Información del poligono:");
        System.out.println(poligono);
        System.out.println("Perimetro del poligono: " + poligono.perimetro());

        // Traslada el polígono y vuelve a imprimir la información con los valores desplazados:
        poligono.traslada(4, -3);
        System.out.println("Información del poligono trasladado:");
        System.out.println(poligono);
        System.out.println("Perimetro del poligono: " + poligono.perimetro());
    }
}
