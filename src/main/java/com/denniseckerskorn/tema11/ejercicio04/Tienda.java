package com.denniseckerskorn.tema11.ejercicio04;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tienda {
    private Electrodomestico lavadora;
    private Electrodomestico television;
    private List<Electrodomestico> electrodomesticos;

    public Tienda() {
        lavadora = new Electrodomestico();
        television = new Television();
        electrodomesticos = new ArrayList<>();
        addElectroDomestico(10);
    }

    private void addElectroDomestico(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            electrodomesticos.add(new Lavadora("negro", 'f', 100, 50, 1));
            electrodomesticos.add(new Television("rojo", 'b', 367, 89, 48, true));
        }
    }

    public List<Electrodomestico> getElectrodomesticos() {
        return electrodomesticos;
    }

    public Electrodomestico getLavadora() {
        return lavadora;
    }

    public Electrodomestico getTelevision() {
        return television;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tienda tienda = (Tienda) o;
        return Objects.equals(electrodomesticos, tienda.electrodomesticos);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(electrodomesticos);
    }

    @Override
    public String toString() {
        return "Tienda{" +
                "lavadora=" + lavadora +
                ", television=" + television +
                ", electrodomesticos=" + electrodomesticos +
                '}' + "\n";
    }
}
