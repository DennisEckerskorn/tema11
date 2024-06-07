package com.denniseckerskorn.tema11.ejercicio06;

import com.denniseckerskorn.lib.ConsoleMenu;
import com.denniseckerskorn.lib.LibIO;
import com.denniseckerskorn.tema11.ejercicio06.multimedia.Multimedia;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;

public class Menu {
    private final TiendaMultimedia tiendaMultimedia;
    private final ConsoleMenu mainMenu;
    private final ConsoleMenu subMenu;

    public Menu() {
        tiendaMultimedia = new TiendaMultimedia();
        mainMenu = new ConsoleMenu("MENÚ PRINCIPAL");
        subMenu = new ConsoleMenu("MENÚ LISTADOS");

        /**
         * Opciones del Menú Principal
         */
        mainMenu.addOpcion("Alta de una nueva Película");
        mainMenu.addOpcion("Alta de un nuevo Videojuego");
        mainMenu.addOpcion("Alta de un nuevo socio");
        mainMenu.addOpcion("Alquilar multimedia a socio");
        mainMenu.addOpcion("Devolver Multimedia");
        mainMenu.addOpcion("Listados");
        mainMenu.addOpcion("Salir");

        /**
         * Opciones del sub menú Listados
         */
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

    /**
     * Switch para las opciones del menú principal.
     */
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
                    alquilarMultimediaASocio();
                    break;
                case 5: //Devolver
                    devolverMultimedia();
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

    /**
     * Switch para las opciones del submenú
     */
    private void showSubMenu() {
        int opcion = -1;
        do {
            opcion = subMenu.mostrarMenuInt();
            switch (opcion) {
                case 1:
                    listaMultimediaCompleto();
                    break;
                case 2:
                    listaPeliculasOrdenadasPorTitulo();
                    break;
                case 3:
                    listaVideoJuegosOrdenadasPorAnyo();
                    break;
                case 4:
                    listaAlquileresSocioOrdenadosPorFecha();
                    break;
                case 5:
                    listaPrestamosSocio();
                    break;
                case 6:
                    listaSociosConRecargosPendientes();
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
        String titulo = LibIO.requestString("Título:", 3, 40);
        Multimedia pelicula = tiendaMultimedia.obtenerMultimediaPorTitulo(titulo);
        if (pelicula == null) {
            String autor = LibIO.requestString("Autor:", 3, 40);
            String anyo = LibIO.requestString("Año:", 4, 4);
            Formato formato = LibIO.requestEnum("Formato:", Formato.class);
            float duracion = LibIO.requestFloat("Duración (en minutos):", 0.00f, 200.00f);
            String actor = LibIO.requestString("Actor:", 3, 40);
            String actriz = LibIO.requestString("Actriz:", 3, 40);
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

    /**
     * Permite añadir un nuevo videojuego a la lista de productos multimedia.
     * Se usa una libreria para validar los datos.
     * Se obtiene una confirmación si se ha añadido correctamente.
     */
    private void addVideojuego() {
        System.out.println("Añadir Videojuego, rellena la información:");
        String titulo = LibIO.requestString("Título", 3, 40);
        Multimedia videojuego = tiendaMultimedia.obtenerMultimediaPorTitulo(titulo);
        if (videojuego == null) {
            String autor = LibIO.requestString("Autor:", 3, 40);
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

    /**
     * Permite añadir un nuevo socio a la lista de socios
     * Comprueba si el socio ya existe mediante su NIF
     * Pide el resto de los datos si el socio no existe aún, de lo contrario saldrá del método
     */
    private void addSocio() {
        System.out.println("Añadir un Socio nuevo, rellena la información:");
        String nif = LibIO.requestString("NIF:", 9, 11); // Ejemplo: 765-86-3224
        Socio socio = tiendaMultimedia.obtenerSocioPorNIF(nif);
        if (socio == null) {
            String nombre = LibIO.requestString("Nombre:", 3, 40);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaNacimiento = LibIO.solicitarFechaLocalDate("Fecha de Nacimiento: (dd/MM/yyyy)", dtf);
            String poblacion = LibIO.requestString("Poblacion:", 3, 40);
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

    /**
     * Permite alquilar un producto multimedia.
     * Se busca y asigna el producto multimedia si existe mediante su título.
     * Se busca y asigna al socio, si existe se asigna al socio mediante su NIF.
     * Crea un préstamo con el producto multimedia y el socio correspondiente.
     */
    private void alquilarMultimediaASocio() {
        System.out.println("Alquilar multimedia a Socio, rellena la información:");

        String titulo = LibIO.requestString("Título del producto Multimedia:", 3, 40);
        Multimedia multimedia = tiendaMultimedia.obtenerMultimediaPorTitulo(titulo);

        if (multimedia != null) {
            System.out.println("Se ha encontrado el producto con título: " + titulo);
            System.out.println(multimedia);
        } else {
            System.out.println("No se ha podido encontrar al producto con el título: " + titulo);
            return;
        }

        String nif = LibIO.requestString("NIF del socio:", 9, 11);
        Socio socio = tiendaMultimedia.obtenerSocioPorNIF(nif);

        if (socio != null) {
            System.out.println("Se ha encontrado al socio con NIF: " + nif);
            System.out.println(socio);
        } else {
            System.out.println("No se ha encontrado al socio con NIF: " + nif);
            return;
        }

        double recargoSocio = socio.calcularRecargosPendientes();
        if (recargoSocio > 0) {
            System.out.println("El socio tiene recargos pendientes de pagar. Antes de alquilar paga los recargos!!!");
            return;
        }

        if (tiendaMultimedia.alquilarMultimediaASocio(multimedia, socio)) {
            System.out.println("El préstamo se ha realizado con éxito.");
        } else {
            System.out.println("No se ha podido realizar el préstamo.");
        }
    }

    /**
     * Permite devolver un producto multimedia prestado por un socio.
     * Busca el producto multimedia y el socio por sus respectivos identificadores,
     * y luego procesa la devolución del producto.
     */
    private void devolverMultimedia() {
        System.out.println("Devolver multimedia prestado por un socio, rellena la información:");

        String titulo = LibIO.requestString("Título del producto:", 3, 40);
        Multimedia multimedia = tiendaMultimedia.obtenerMultimediaPorTitulo(titulo);

        if (multimedia == null) {
            System.out.println("No se ha encontrado un producto multimedia con el título: " + titulo);
            return;
        }

        String nif = LibIO.requestString("NIF del socio:", 9, 11);
        Socio socio = tiendaMultimedia.obtenerSocioPorNIF(nif);

        if (socio == null) {
            System.out.println("No se ha encontrado un socio con el NIF: " + nif);
            return;
        }

        boolean validReturn = tiendaMultimedia.devolverPrestamo(multimedia, socio);

        if (validReturn) {
            System.out.println("El producto multimedia se ha devuelto exitosamente.");
        } else {
            System.out.println("No se pudo devolver el producto multimedia.");
        }
    }


    /**
     * Muestra la lista completa de todos los objetos multimedia en la tienda.
     */
    private void listaMultimediaCompleto() {
        Collection<Multimedia> multimedia = tiendaMultimedia.obtenerMultimediaCompleto();
        if (multimedia != null) {
            System.out.println(multimedia.toString());
        } else {
            System.out.println("No hay productos...");
        }
    }

    /**
     * Muestra la lista de películas ordenadas por título.
     */
    private void listaPeliculasOrdenadasPorTitulo() {
        List<Multimedia> peliculas = tiendaMultimedia.obtenerPeliculasOrdenadasPorTitulo();
        if (peliculas != null) {
            System.out.println(peliculas.toString());
        } else {
            System.out.println("No hay Peliculas...");
        }
    }

    /**
     * Muestra la lista de videojuegos ordenados por año.
     */
    private void listaVideoJuegosOrdenadasPorAnyo() {
        List<Multimedia> videojuegos = tiendaMultimedia.obtenerVidejuegosPorAnyo();
        if (videojuegos != null) {
            System.out.println(videojuegos.toString());
        } else {
            System.out.println("No hay Videojuegos...");
        }
    }

    /**
     * Muestra la lista de préstamos ordenados por fecha.
     */
    private void listaAlquileresSocioOrdenadosPorFecha() {
        List<Prestamo> historicoPrestamos = tiendaMultimedia.obtenerHistoricoPrestamosPorFecha();
        if (historicoPrestamos != null) {
            System.out.println(historicoPrestamos.toString());
        } else {
            System.out.println("No existe ningun historico...");
        }
    }

    /**
     * Muestra la lista de socios que tienen recargos pendientes.
     */
    private void listaSociosConRecargosPendientes() {
        List<Socio> sociosRecargosPendientes = tiendaMultimedia.obtenerSociosConRecargosPendientes();
        if (sociosRecargosPendientes != null) {
            System.out.println(sociosRecargosPendientes.toString());
        } else {
            System.out.println("No existen socios con recargos pendientes...");
        }
    }

    /**
     * Muestra la lista de préstamos de un socio específico.
     * Pide el NIF del socio y muestra sus préstamos.
     */
    private void listaPrestamosSocio() {
        System.out.println("De que socio quieres mostrar los prestamos?");
        String nif = LibIO.requestString("NIF del socio:", 9, 11);
        Socio socio = tiendaMultimedia.obtenerSocioPorNIF(nif);
        if (socio != null) {
            System.out.println("Lista de préstamos del socio:");
            List<Prestamo> prestamos = socio.getPrestamos();
            if (!prestamos.isEmpty()) {
                for (Prestamo prestamo : prestamos) {
                    System.out.println(prestamo);
                }
            } else {
                System.out.println("El socio no tiene prestamos registrados.");
            }
        } else {
            System.out.println("No se ha encontrado al socio con NIF: " + nif);
        }
    }
}
