package com.denniseckerskorn.tema11.ejercicio07;

import com.denniseckerskorn.lib.ConsoleMenu;

public class MenuEstadio {
    private ConsoleMenu mainMenu;
    private ConsoleMenu subMenu;

    public MenuEstadio() {
        mainMenu = new ConsoleMenu("GESTIÓN PARTIDOS");

        subMenu = new ConsoleMenu("GESTIÓN ENTRADAS");
    }
}
