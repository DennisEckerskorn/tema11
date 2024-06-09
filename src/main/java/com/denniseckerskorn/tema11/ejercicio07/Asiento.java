package com.denniseckerskorn.tema11.ejercicio07;

public class Asiento {
    private final int numAsiento;
    private boolean ocupado;

    public Asiento(int numAsiento, boolean ocupado) {
        this.numAsiento = numAsiento;
        this.ocupado = ocupado;
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
        return numAsiento == asiento.numAsiento;
    }

    @Override
    public int hashCode() {
        return numAsiento;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Asiento: ").append(numAsiento);
        if(isOcupado()) {
            sb.append(" - Ocupado");
        } else {
            sb.append(" - Libre");
        }
        return sb.toString();
    }
}
