package com.denniseckerskorn.tema11.ejercicio05.gameobjects;

public abstract class GameObject {

    private String nombre;
    private boolean apilable;
    private int maxCantidad;

    public GameObject(String nombre, boolean apilable, int maxCantidad) {
        this.nombre = nombre;
        this.apilable = apilable;
        this.maxCantidad = maxCantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isApilable() {
        return apilable;
    }

    public int getMaxCantidad() {
        return maxCantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameObject that = (GameObject) o;
        return apilable == that.apilable && maxCantidad == that.maxCantidad && nombre.equals(that.nombre);
    }

    @Override
    public int hashCode() {
        int result = nombre.hashCode();
        result = 31 * result + Boolean.hashCode(apilable);
        result = 31 * result + maxCantidad;
        return result;
    }

    @Override
    public String toString() {
        return "GameObjects{" +
                "nombre='" + nombre + '\'' +
                ", apilable=" + apilable +
                ", maxCantidad=" + maxCantidad +
                '}';
    }
}
