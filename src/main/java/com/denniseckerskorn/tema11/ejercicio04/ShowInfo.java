package com.denniseckerskorn.tema11.ejercicio04;

public class ShowInfo {
    private Tienda tienda;

    public ShowInfo() {
        tienda = new Tienda();
        System.out.println(tienda.toString());
        resultadoFinal();
    }

    public void resultadoFinal() {
        for (Electrodomestico e : tienda.getElectrodomesticos()) {
            double total = 0.0;
            double precioFinalElectro = e.precioFinal();
            System.out.println("Precio final Electrodomestico: " + precioFinalElectro);
            total += precioFinalElectro;

            if (e instanceof Lavadora) {
                Electrodomestico lavadora = (Lavadora) e;
                double precioFinalLavadora = lavadora.precioFinal();
                System.out.println("Precio final Lavadora: " + precioFinalLavadora);
                total += precioFinalLavadora;
            }

            if (e instanceof Television) {
                Electrodomestico television = (Television) e;
                double precioFinalTV = television.precioFinal();
                System.out.println("Precio final Television: " + precioFinalTV);
                total += precioFinalTV;
            }
            System.out.println(total);
        }
    }
}

