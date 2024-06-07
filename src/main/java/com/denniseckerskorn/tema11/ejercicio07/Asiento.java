package com.denniseckerskorn.tema11.ejercicio07;

public class Asiento {
    private final int numAsiento;

    public Asiento(int numAsiento) {
        this.numAsiento = numAsiento;
    }

    public int getNumAsiento() {
        return numAsiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Asiento asiento = (Asiento) o;
        return numAsiento == asiento.numAsiento;
    }

    @Override
    public int hashCode() {
        return numAsiento;
    }

    @Override
    public String toString() {
        return "Asiento{" +
                "numAsiento=" + numAsiento +
                '}';
    }
}
