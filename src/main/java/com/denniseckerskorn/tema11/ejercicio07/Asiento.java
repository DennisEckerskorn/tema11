package com.denniseckerskorn.tema11.ejercicio07;

public class Asiento {
    private static final boolean DEFAULT_OCUPADO = false;
    private static int nextID = 0;
    private final int numAsiento;
    private boolean ocupado;

    public Asiento(boolean ocupado) {
        this.numAsiento = ++nextID;
        this.ocupado = ocupado;
    }

    public Asiento() {
        this(DEFAULT_OCUPADO);
    }

    public int getNumAsiento() {
        return numAsiento;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Asiento asiento = (Asiento) o;
        return numAsiento == asiento.numAsiento && ocupado == asiento.ocupado;
    }

    @Override
    public int hashCode() {
        int result = numAsiento;
        result = 31 * result + Boolean.hashCode(ocupado);
        return result;
    }

    @Override
    public String toString() {
        return "{Asiento: " + numAsiento + ", Ocupado: " + ocupado + "}";
    }
}
