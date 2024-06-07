package com.denniseckerskorn;

import com.denniseckerskorn.tema11.ejercicio02.InfoPuntoPoligono;
import com.denniseckerskorn.tema11.ejercicio03.App;
import com.denniseckerskorn.tema11.ejercicio04.Lavadora;
import com.denniseckerskorn.tema11.ejercicio04.ShowInfo;
import com.denniseckerskorn.tema11.ejercicio05.inventory.InventoryMenu;
import com.denniseckerskorn.tema11.ejercicio06.Menu;
import com.denniseckerskorn.tema11.ejercicio07.zonas.Zona;
import com.denniseckerskorn.tema11.ejercicio07.zonas.ZonaNormal;

public class Main {
    public static void main(String[] args) {
        //InfoPuntoPoligono principal = new InfoPuntoPoligono();
        //App app = new App();
        //ShowInfo showInfo = new ShowInfo();

        //Menu menu = new Menu();
        //InventoryMenu inventoryMenu = new InventoryMenu();

        Zona zonaNormal = new ZonaNormal(10, 10);
        zonaNormal.getAsientos().forEach((key, value) -> {
            System.out.println("Fila - Columna: " + key + ", Asiento: " + value);
        });
    }
}