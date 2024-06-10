package com.denniseckerskorn.tema11.ejercicio07.entradas;

import com.denniseckerskorn.tema11.ejercicio07.Partido;
import com.denniseckerskorn.tema11.ejercicio07.TipoPartido;
import com.denniseckerskorn.tema11.ejercicio07.Zona;

import java.util.Random;

public class EntradaNormal extends Entrada {
    private final int numeroLoteria;

    public EntradaNormal(Partido partido, Zona zona, int fila, int asiento) {
        super(partido, zona, fila, asiento);
        this.numeroLoteria = getRandom().nextInt(zona.getTotalAsientos()) + 1;
    }

    public int getNumeroLoteria() {
        return numeroLoteria;
    }

    @Override
    public String toString() {
        return super.toString() + "EntradaNormal{" +
                ", numeroLoteria=" + numeroLoteria +
                '}';
    }
}
