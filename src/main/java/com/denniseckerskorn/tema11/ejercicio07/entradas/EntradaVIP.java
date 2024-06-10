package com.denniseckerskorn.tema11.ejercicio07.entradas;

import com.denniseckerskorn.tema11.ejercicio07.Partido;
import com.denniseckerskorn.tema11.ejercicio07.TipoPartido;
import com.denniseckerskorn.tema11.ejercicio07.Zona;

import java.util.Objects;

public class EntradaVIP extends Entrada {
    private final String codigoUnico;

    public EntradaVIP(Partido partido, Zona zona, int fila, int asiento) {
        super(partido, zona, fila, asiento);
        this.codigoUnico = generatePassword(8);
    }

    private String generatePassword(int passwordSize) {
        StringBuilder sb = new StringBuilder(passwordSize);
        for(int i = 0; i < passwordSize; i++) {
            char c = (char) ((char) getRandom().nextInt(65, 122) + 1);
            sb.append(c);
        }
        return sb.toString();
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        EntradaVIP that = (EntradaVIP) o;
        return Objects.equals(codigoUnico, that.codigoUnico);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(codigoUnico);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "EntradaVIP{" +
                "codigoUnico='" + codigoUnico + '\'' +
                '}';
    }
}
