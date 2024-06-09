package com.denniseckerskorn.tema11.ejercicio07.entradas;

import com.denniseckerskorn.tema11.ejercicio07.TipoPartido;
import com.denniseckerskorn.tema11.ejercicio07.Zona;

import java.util.Random;

public class EntradaNormal extends Entrada {
    private Random random;
    private final int numeroLoteria;

    public EntradaNormal(TipoPartido tipoPartido, Zona zona, int fila, int asiento) {
        super(tipoPartido, zona, fila, asiento);
        random = new Random();
        this.numeroLoteria = random.nextInt(zona.getTotalAsientos()) + 1;
    }

    public int getNumeroLoteria() {
        return numeroLoteria;
    }

    @Override
    public String toString() {
        return super.toString() + "EntradaNormal{" +
                "random=" + random +
                ", numeroLoteria=" + numeroLoteria +
                '}';
    }
}
