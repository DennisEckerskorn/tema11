package com.denniseckerskorn.tema11.ejercicio07;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fila {
    private static final int DEFAULT_ASIENTOS = 10;
    private final List<Asiento> asientos;
    private final int numFila;
    private Random random;

    public Fila(int numFila) {
        this.asientos = new ArrayList<>(DEFAULT_ASIENTOS);
        this.numFila = numFila;

        for (int i = 1; i <= DEFAULT_ASIENTOS; i++) {
            asientos.add(new Asiento(i, false));
        }
    }

    public boolean addAsiento(int numAsiento, boolean ocupado) {
        Asiento asiento = new Asiento(numAsiento, ocupado);
        for(int i = 0; i < asientos.size(); i++) {
            if(asientos.get(i).getNumAsiento() == numAsiento) {
                return false;
            }
        }
        return asientos.add(asiento);
    }

    public int getRandomAsiento() throws IllegalArgumentException {
        List<Integer> availableSeats = new ArrayList<>();
        for(Asiento asiento : asientos) {
            if(!asiento.isOcupado()) {
                availableSeats.add(asiento.getNumAsiento());
            }
        }
        if(availableSeats.isEmpty()) {
            throw new IllegalArgumentException("No hay asientos disponibles en la fila ");
        }
        return availableSeats.get(random.nextInt(availableSeats.size()));
    }

    public boolean marcarAsientoOcupado(int numeroAsiento) {
        Asiento asiento = asientos.get(numeroAsiento);
        if (asiento != null && asiento.isOcupado()) {
            asiento.setOcupado(true);
            return true;
        }
        return false;
    }
    public List<Asiento> getAsientos() {
        return asientos;
    }

    public int getNumFila() {
        return numFila;
    }

    public int getNumeroAsientos() {
        return asientos.size();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fila fila = (Fila) o;
        return numFila == fila.numFila && asientos.equals(fila.asientos);
    }

    @Override
    public int hashCode() {
        int result = asientos.hashCode();
        result = 31 * result + numFila;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FILA = ").append(numFila).append("\n");
        sb.append("Asientos{").append(asientos).append("}\n");
        return sb.toString();
    }
}
