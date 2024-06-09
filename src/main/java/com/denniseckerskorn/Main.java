package com.denniseckerskorn;

import com.denniseckerskorn.tema11.ejercicio07.TipoZona;
import com.denniseckerskorn.tema11.ejercicio07.Zona;

public class Main {
    public static void main(String[] args) {
        //InfoPuntoPoligono principal = new InfoPuntoPoligono();
        //App app = new App();
        //ShowInfo showInfo = new ShowInfo();

        //Menu menu = new Menu();
        //InventoryMenu inventoryMenu = new InventoryMenu();

        Zona zona = new Zona(TipoZona.ZONA_NORMAL, 10.00);
        System.out.println(zona);

    }
}