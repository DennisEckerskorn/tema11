package com.denniseckerskorn.tema11.ejercicio06;

import com.denniseckerskorn.lib.ConsoleMenu;
import com.denniseckerskorn.lib.LibIO;

import javax.swing.text.html.ListView;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

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
        mainMenu.addOpcion("Alquilar multimedia a socio");
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
                case 1: //Add Pelicula
                    addPelicula();
                    break;
                case 2: //Add Videojeugo
                    addVideojuego();
                    break;
                case 3: //Add Socio
                    addSocio();
                    break;
                case 4: //Alquilar
                    break;
                case 5: //Devolver
                    break;
                case 6: //Listados
                    showSubMenu();
                    break;
                case 7: //Salir
                    System.out.println("Hasta pronto...");
                    break;
                default:
                    System.out.println("Solo se permiten números entre 0 y 5");
                    break;
            }

        } while (opcion != 7);
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

    /**
     * Permite añadir una nueva pelicula a la lista de productos multimedia de la tiendaMultimedia.
     * Se usa la libreria para validar los datos.
     * Se obtiene una condfirmación si se ha añadio correctamente.
     */
    private void addPelicula() {
        System.out.println("Añadir Pelicula, rellena la información:");
        String titulo = LibIO.requestString("Título:", 3, 20);
        Multimedia pelicula = tiendaMultimedia.obtenerMultimediaPorTitulo(titulo);
        if (pelicula == null) {
            String autor = LibIO.requestString("Autor:", 3, 20);
            String anyo = LibIO.requestString("Año:", 4, 4);
            Formato formato = LibIO.requestEnum("Formato:", Formato.class);
            float duracion = LibIO.requestFloat("Duración (en minutos):", 0.00f, 200.00f);
            String actor = LibIO.requestString("Actor:", 3, 20);
            String actriz = LibIO.requestString("Actriz:", 3, 20);
            boolean added = tiendaMultimedia.addPelicula(titulo, autor, anyo, formato, duracion, actor, actriz);
            if (added) {
                System.out.println("La película se ha añadido correctamente");
            } else {
                System.out.println("No se ha podido añadir la película. Intentalo de nuevo");
            }
        } else {
            System.out.println("La película ya existe con el título proporcionado: " + titulo);
        }
    }

    private void addVideojuego() {
        System.out.println("Añadir Videojuego, rellena la información:");
        String titulo = LibIO.requestString("Título", 3, 20);
        Multimedia videojuego = tiendaMultimedia.obtenerMultimediaPorTitulo(titulo);
        if (videojuego == null) {
            String autor = LibIO.requestString("Autor:", 3, 20);
            String anyo = LibIO.requestString("Año:", 4, 4);
            Formato formato = LibIO.requestEnum("Formato:", Formato.class);
            Plataforma plataforma = LibIO.requestEnum("Plataforma:", Plataforma.class);
            boolean added = tiendaMultimedia.addVideojuego(titulo, autor, anyo, formato, plataforma);
            if (added) {
                System.out.println("El videojuego se ha añadido correctamente");
            } else {
                System.out.println("No se ha podido añadir al videojeugo. Intentalo de nuevo");
            }
        } else {
            System.out.println("El videojuego ya existe con el título proporcionado");
        }
    }

    private void addSocio() {
        System.out.println("Añadir un Socio nuevo, rellena la información:");
        String nif = LibIO.requestString("NIF:", 9, 11); // Ejemplo: 765-86-3224
        Socio socio = tiendaMultimedia.obtenerSocioPorNIF(nif);
        if (socio == null) {
            String nombre = LibIO.requestString("Nombre:", 3, 20);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaNacimiento = LibIO.solicitarFechaLocalDate("Fecha de Nacimiento: (dd/MM/yyyy)", dtf);
            String poblacion = LibIO.requestString("Poblacion:", 3, 20);
            try {
                tiendaMultimedia.addSocio(nif, nombre, fechaNacimiento, poblacion);
                System.out.println("El socio se ha añadido correctamente");
            } catch (IllegalArgumentException iae) {
                System.out.println("No se ha podido añadir al socio. Intentalo de nuevo");
                System.out.println(iae.getMessage());
            }
        } else {
            System.out.println("El socio con NIF " + nif + " ya existe");
        }
    }


    private void alquilarMultimedia() {
        String titulo = LibIO.requestString("Introduce el título:", 3, 40);

    }
}
