package com.denniseckerskorn.tema11.ejercicio06;

import com.denniseckerskorn.lib.ConsoleMenu;
import com.denniseckerskorn.lib.LibIO;

public class Menu {
    private final TiendaMultimedia tiendaMultimedia;
    private final ConsoleMenu mainMenu;
    private final ConsoleMenu subMenu;

    public Menu() {
        tiendaMultimedia = new TiendaMultimedia();
        mainMenu = new ConsoleMenu("MENÚ PRINCIPAL");
        subMenu = new ConsoleMenu("MENÚ LISTADOS");

        mainMenu.addOpcion("Alta de una nueva Película");
        mainMenu.addOpcion("Alta de un nuevo Videojuego");
        mainMenu.addOpcion("Alta de un nuevo socio");
        mainMenu.addOpcion("Devolver Multimedia");
        mainMenu.addOpcion("Listados");
        mainMenu.addOpcion("Salir");

        subMenu.addOpcion("Listado de todos los objetos multimedia");
        subMenu.addOpcion("Listado de todas las peliculas ordenadas por título");
        subMenu.addOpcion("Listado de todos los videojuegos ordenados por años");
        subMenu.addOpcion("Listado del histórico de alquileres de un socio ordenados por fecha de alquiler");
        subMenu.addOpcion("Listado de los alquileres actuales de un socio");
        subMenu.addOpcion("Listado de los socios con recargos pendientes");
        subMenu.addOpcion("Volver al menú principal");

        System.out.println(tiendaMultimedia);
        showMainMenu();
    }

    private void showMainMenu() {
        int opcion = -1;
        do {
            opcion = mainMenu.mostrarMenuInt();
            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    showSubMenu();
                    break;
                case 6:
                    System.out.println("Hasta pronto...");
                    break;
                default:
                    System.out.println("Solo se permiten números entre 0 y 5");
                    break;
            }

        } while (opcion != 6);
    }

    private void showSubMenu() {
        int opcion = -1;
        do {
            opcion = subMenu.mostrarMenuInt();
            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("Volviendo al menú inicial...");
                    break;
                default:
                    System.out.println("Solo se permiten números entre 0 y 7");
                    break;
            }

        } while (opcion != 7);
    }

    private void alquilarMultimedia() {
        String titulo = LibIO.requestString("Introduce el título:", 3, 40);

    }
}
