package com.denniseckerskorn.tema11.ejercicio07;

import com.denniseckerskorn.lib.ConsoleMenu;
import com.denniseckerskorn.lib.LibIO;
import com.denniseckerskorn.tema11.ejercicio07.entradas.Entrada;
import com.denniseckerskorn.tema11.ejercicio07.entradas.EntradaNormal;
import com.denniseckerskorn.tema11.ejercicio07.entradas.EntradaVIP;

import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class MenuEstadio {
    private ConsoleMenu mainMenu;
    private ConsoleMenu subMenu;
    private Estadio estadio;

    public MenuEstadio() {
        estadio = new Estadio("Estadio Principal");
        //Testing:
        System.out.println(estadio);

        mainMenu = new ConsoleMenu("GESTIÓN PARTIDOS");
        mainMenu.addOpcion("Nuevo Partido");
        mainMenu.addOpcion("Gestión Entradas");
        mainMenu.addOpcion("Salir");

        subMenu = new ConsoleMenu("GESTIÓN ENTRADAS");
        subMenu.addOpcion("Venta de entradas");
        subMenu.addOpcion("Devolver entrada");
        subMenu.addOpcion("Listado de localidades ocupadas");
        subMenu.addOpcion("Listado de localidades libres");
        subMenu.addOpcion("Mostrar recaudación del partido");
        subMenu.addOpcion("Volver al menú principal");

        showMainMenu();

    }

    private void showMainMenu() {
        int opcion = -1;

        do {
            opcion = mainMenu.mostrarMenuInt();
            switch (opcion) {
                case 1: //Nuevo Partido
                    createPartido();
                    break;
                case 2: //Gestión Entradas
                    showSubMenu();
                    break;
                case 3: //Salir
                    break;
                default:
                    System.out.println("Numero no está dentro del rango [1 - 3]");
                    break;
            }
        } while (opcion != 3);
    }

    private void showSubMenu() {
        int opcion = -1;
        opcion = subMenu.mostrarMenuInt();
        switch (opcion) {
            case 1: //Venta entradas
                ventaEntradas();
                break;
            case 2: //Devolver entrada
                devolverEntrada();
                break;
            case 3: //Listado localidades ocupadas
                listadoAsientosOcupados();
                break;
            case 4: //Listado Localidades libres
                listadoAsientosDisponibles();
                break;
            case 5: //Mostrar recaudación del partido
                mostrarRecaudacion();
                break;
            case 6: //Volver
                break;
            default:
                System.out.println("Numero no está dentro del rango [1 - 6]");
                break;
        }
    }

    private void createPartido() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Bienvenido a la creación de un partido, rellena la información:");
        LocalDate fechaPartido = LibIO.solicitarFechaLocalDate("Fecha del partido (dd/mm/yyyy):", dtf);
        String conversionfecha = fechaPartido.format(dtf);
        TipoPartido tipoPartido = LibIO.requestEnum("Elige el tipo del partido:", TipoPartido.class);
        String equipoLocal = LibIO.requestString("Nombre equipo local:", 2, 20);
        String equipoVisitante = LibIO.requestString("Nombre equipo visitante:", 2, 20);

        try {
            estadio.addPartido(equipoLocal, equipoVisitante, tipoPartido, conversionfecha);
        } catch (DateTimeParseException dtpe) {
            System.err.println(dtpe.getMessage());
        }
    }

    private void ventaEntradas() {
        Partido partido = partidosDisponibles();
        Zona zona = zonaDisponible();
        Fila fila = filasDisponibles(zona);
        int numFila = fila.getNumFila();
        Asiento asiento = asientosDisponibles(fila);
        int numAsiento = asiento.getNumAsiento();

        if (zona.getTipoZona().equals(TipoZona.ZONA_VIP)) {
            Entrada entradaVIP = new EntradaVIP(partido, zona, numFila, numAsiento);
            partido.addEntrada(entradaVIP);
            System.out.println(entradaVIP + " se ha añadido con éxito");
        } else {
            Entrada entradaNormal = new EntradaNormal(partido, zona, numFila, numAsiento);
            partido.addEntrada(entradaNormal);
            System.out.println(entradaNormal + " se ha añadido con éxito");
        }
    }

    private void mostrarRecaudacion() {
        System.out.println("La recaudación total de las entradas por partido son:");
        double total = partidosDisponibles().calcularTotalEntradasVendidas();
        System.out.println(total);
    }

    private void listadoAsientosOcupados() {
        List<Asiento> asientosOcupados = estadio.asientosOcupados();
        for(int i = 0; i < asientosOcupados.size(); i++) {
            System.out.println((i + 1) + ". " + asientosOcupados); //Falta enseñar la fila y zona
        }
    }

    private void listadoAsientosDisponibles() {
        List<Asiento> asientosDisponibles = estadio.asientosDisponibles();
        for(int i = 0; i < asientosDisponibles.size(); i++) {
            System.out.println((i + 1) + ". " + asientosDisponibles); //Falta enseñar la fila y zona
        }
    }

    private void devolverEntrada() {
        int id = LibIO.requestInt("Ingresa el número identificador de la entrada:", 1, 3);
        Entrada entrada = estadio.obtenerEntradaPartidoPorID(id);
        if (entrada != null) {
            Zona zona = entrada.getZona();
            int fila = entrada.getFila();
            int asiento = entrada.getAsiento();
            boolean asientoDevuelto = zona.marcarAsientoDisponible(fila, asiento);

            if (asientoDevuelto) {
                estadio.eliminarEntrada(entrada);
                System.out.println("La entrada ha sido devuelta con éxito");
            } else {
                System.out.println("No se ha podido devolver la entrada");
            }
        } else {
            System.out.println("No se ha encontrado ninguna entrada en el id " + id);
        }

    }

    private Zona zonaDisponible() {
        List<Zona> zonasDisponibles = new ArrayList<>(estadio.getMapZonas().values());
        if (zonasDisponibles.isEmpty()) {
            System.out.println("No hay zonas disponibles:");
        }

        for (int i = 0; i < zonasDisponibles.size(); i++) {
            Zona zona = zonasDisponibles.get(i);
            System.out.println((i + 1) + ". " + zona);
        }

        int zonaSeleccionada = LibIO.requestInt("Elige la zona", 1, zonasDisponibles.size());
        Zona zona = zonasDisponibles.get(zonaSeleccionada - 1);
        int zoneID = zona.getZoneID();
        return estadio.getMapZonas().get(zoneID);
    }

    private Partido partidosDisponibles() {
        List<Partido> partidosDisponibles = new ArrayList<>(estadio.getPartidos());
        if (partidosDisponibles.isEmpty()) {
            System.out.println("No hay partidos disponibles...");
        }
        System.out.println("Partidos disponibles:");

        for (int i = 0; i < partidosDisponibles.size(); i++) {
            Partido partido = partidosDisponibles.get(i);
            System.out.println((i + 1) + ". " + partido);
        }

        int partidoSeleccionado = LibIO.requestInt("Elige el partido:", 1, partidosDisponibles.size());

        return estadio.getPartidos().get(partidoSeleccionado - 1);
    }

    private Fila filasDisponibles(Zona zona) {
        List<Fila> filasDisponibles = new ArrayList<>(zona.getFilas());
        if (filasDisponibles.isEmpty()) {
            System.out.println("No hay filas disponibles...");
        }
        System.out.println("Filas disponibles");

        for (int i = 0; i < filasDisponibles.size(); i++) {
            Fila fila = zona.getFilas().get(i);
            System.out.println((i + 1) + ". " + fila);
        }

        int filaSeleccionada = LibIO.requestInt("Elige la fila:", 1, filasDisponibles.size());
        Fila fila = filasDisponibles.get(filaSeleccionada - 1);
        return fila;
    }

    private Asiento asientosDisponibles(Fila fila) {
        List<Asiento> asientosDisponibles = new ArrayList<>(fila.getAsientos());
        if (asientosDisponibles.isEmpty()) {
            System.out.println("No hay asientos disponibles");
        }

        System.out.println("Asientos disponibles:");
        for (int i = 0; i < asientosDisponibles.size(); i++) {
            Asiento asiento = fila.getAsientos().get(i);
            System.out.println((i + 1) + ". " + asiento);
        }

        int asientoSeleccionado = LibIO.requestInt("Elige el asiento: ", 1, asientosDisponibles.size());
        Asiento asiento = asientosDisponibles.get(asientoSeleccionado - 1);
        asiento.setOcupado(true);

        return asiento;
    }
}
