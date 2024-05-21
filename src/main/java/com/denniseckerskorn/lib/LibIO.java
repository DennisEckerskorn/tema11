package com.denniseckerskorn.lib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//Library which includes general methods for INPUT/OUTPUT.
public class LibIO {
    private static final Scanner LECTOR = new Scanner(System.in);


    // **** METHODS TO READ USER INPUT WITH SCANNER FOR DIFFERENT DATA TYPES, NO VALIDATION: ****

    /**
     * Method which prompts the user with a message and validates if the user input is equal to "true" or "false".
     *
     * @param message The message displayed to the user for input.
     * @return True if the user input is "true", false if it's "false".
     */
    public static boolean validateBoolean(String message) {
        boolean valid = false;
        String result = "";
        do {
            System.out.println(message);
            try {
                result = LECTOR.nextLine().trim().toLowerCase();
                valid = result.equals("true") || result.equals("false");
                if (!valid) {
                    System.out.println("Error, only true or false");
                }

            } catch (NoSuchElementException nee) {
                System.out.println("There is no input, please introduce 'true' or 'false'");
            }
        } while (!valid);
        return Boolean.parseBoolean(result);
    }

    /**
     * Method which receives a String as message and validates if the user input is equal to "yes" or "no"
     *
     * @param message String
     * @return boolean true or false.
     */
    public static boolean validateYesNo(String message) {
        boolean valid = false;
        String result = "";
        do {
            System.out.println(message);
            try {
                result = LECTOR.nextLine().trim().toLowerCase();
                valid = result.equals("si") || result.equals("no");
                if (!valid) {
                    System.out.println("Error, solo 'si' o 'no' son permitidos");
                }
            } catch (NoSuchElementException nsee) {
                System.out.println("No hay entrada. Introduce un si o no");
            }
        } while (!valid);
        return result.equals("si");
    }

    /**
     * Method to request a Byte showing a message as parameter, NO validation included.
     *
     * @param message for user (String).
     * @return byte introduced by user.
     */
    public static byte requestByte(String message) {
        System.out.println(message);
        return Byte.parseByte(LECTOR.nextLine());
    }

    /**
     * Method to request an Integer showing a message as parameter, NO validation included.
     *
     * @param message for user (String).
     * @return int introduced by user.
     */
    public static int requestInt(String message) {
        int res = 0;
        try {
            System.out.println(message);
            res = Integer.parseInt(LECTOR.nextLine());

        } catch (NumberFormatException nfe) {
            System.out.println("Solo se permiten introducir números.");
        }
        return res;
    }

    /**
     * Method to request a Long showing a message as parameter, NO validation included.
     *
     * @param message for user (String).
     * @return long introduced by user.
     */
    public static long requestLong(String message) {
        System.out.println(message);
        return Long.parseLong(LECTOR.nextLine());
    }

    /**
     * Method to request a Float showing a message as parameter, NO validation included.
     *
     * @param message for user (String).
     * @return float introduced by user.
     */
    public static float requestFloat(String message) {
        System.out.println(message);
        return Float.parseFloat(LECTOR.nextLine());
    }

    /**
     * Method to request a Double showing a message as parameter, NO validation included.
     *
     * @param message for user (String).
     * @return double introduced by user.
     */
    public static double requestDouble(String message) {
        System.out.println(message);
        return Double.parseDouble(LECTOR.nextLine());
    }

    /**
     * Method to request a Char showing a message as parameter, NO validation included.
     *
     * @param message for user (String).
     * @return char introduced by user.
     */
    public static char requestChar(String message) {
        System.out.println(message);
        return LECTOR.nextLine().charAt(0);
    }

    /**
     * Method to request a String showing a message as parameter, NO validation included.
     *
     * @param message for user (String).
     * @return String introduced by user.
     */
    public static String requestString(String message) {
        System.out.println(message);
        return LECTOR.nextLine();
    }


    // **** METHODS TO READ USER INPUT SHOWING A MESSAGE FOR THE USER, THESE METHODS INCLUDE VALIDATION. ****


    /**
     * Method to request a Byte showing a message for the user, validation between min value and max value.
     *
     * @param message for user (String).
     * @param min     value (byte).
     * @param max     value (byte).
     * @return byte introduced by user and validated.
     */
    public static byte requestByte(String message, byte min, byte max) {
        boolean valid = false;
        byte result = -1;
        do {
            System.out.println(message);
            try {
                result = Byte.parseByte(LECTOR.nextLine());
                valid = (result >= min && result <= max);
                if (!valid) {
                    System.out.printf("Error => Minimum Value: %d, Maximum Value: %d\n", min, max);
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Error => Only numbers can be entered");
            }
        } while (!valid);
        return result;
    }

    /**
     * Method to request an Integer showing a message for the user, validation between min value and max value.
     *
     * @param message for user (String).
     * @param min     value (int).
     * @param max     value (int).
     * @return int introduced by user and validated.
     */
    public static int requestInt(String message, int min, int max) {
        boolean valid = false;
        int result = -1;
        do {
            System.out.println(message);
            try {
                result = Integer.parseInt(LECTOR.nextLine());
                valid = (result >= min && result <= max);
                if (!valid) {
                    System.out.printf("Error => Minimum Value: %d, Maximum Value: %d\n", min, max);
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Error => Only numbers can be entered");
            }
        } while (!valid);
        return result;
    }

    /**
     * Method to request a Long showing a message for the user, validation between min value and max value.
     *
     * @param message for user (String).
     * @param min     value (long).
     * @param max     value (long).
     * @return long introduced by user and validated.
     */
    public static long requestLong(String message, long min, long max) {
        boolean valid = false;
        long result = -1;
        do {
            System.out.println(message);
            try {
                result = Long.parseLong(LECTOR.nextLine());
                valid = (result >= min && result <= max);
                if (!valid) {
                    System.out.printf("Error => Minimum Value: %d, Maximum Value: %d\n", min, max);
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Error => Only numbers can be entered");
            }
        } while (!valid);
        return result;
    }

    /**
     * Method to request a Float showing a message for the user, validation between min value and max value.
     *
     * @param message for user
     * @param min     value (float)
     * @param max     value (float)
     * @return float introduced by user and validated.
     */
    public static float requestFloat(String message, float min, float max) {
        boolean valid = false;
        float result = Float.MIN_VALUE;
        do {
            try {
                System.out.println(message);
                result = Float.parseFloat(LECTOR.nextLine());
                valid = (result >= min && result <= max);
                if (!valid) {
                    System.out.printf("Error => Minimum Value: %.2f, Maximum Value: %.2f\n", min, max);
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Error => Only numbers can be entered");
            }
        } while (!valid);
        return result;
    }

    /**
     * Method to request a Double showing a message for the user, validation between min and max value.
     *
     * @param message for user (String)
     * @param min     value (double)
     * @param max     value (double)
     * @return double introduced by user and validated.
     */
    public static double requestDouble(String message, double min, double max) {
        boolean valid = false;
        double result = Double.NEGATIVE_INFINITY;
        do {
            System.out.println(message);
            try {
                result = Double.parseDouble(LECTOR.nextLine());
                valid = (result >= min && result <= max);
                if (!valid) {
                    System.out.printf("Error => Minimum Value: %.2f, Maximum Value: %.2f\n", min, max);
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Error => Only numbers can be entered");
            }
        } while (!valid);
        return result;
    }

    /**
     * Method to request a certain Character, Message and Character to request is passed as parameter.
     * After reading the character it will be changed to lower case.
     * If not valid, it will keep asking for the character.
     *
     * @param message for user (String).
     * @param c       Character to validate.
     * @return validated character which was introduced by user.
     */
    public static char requestChar(String message, char c) {
        char result = ' ';
        boolean valid = false;
        do {
            System.out.println(message);
            try {
                result = LECTOR.nextLine().toLowerCase().charAt(0);
                valid = result == Character.toLowerCase(c);
                if (!valid) {
                    System.out.printf("The character should be %c\n", c);
                }
            } catch (NoSuchElementException nsee) {
                System.out.println("No input was provided. Please enter a character.");
            }
        } while (!valid);
        return result;
    }

    /**
     * Method to request two Characters, Message and Characters to request is passed as parameter.
     * After reading the characters they will be changed to lower case.
     * If not valid, it will keep asking for the character.
     *
     * @param message for user (String).
     * @param c1      Character to validate (char).
     * @param c2      Character to validate (char).
     * @return validated character which was introduced by user.
     */
    public static char requestChar(String message, char c1, char c2) {
        char result = ' ';
        boolean valid = false;
        do {
            System.out.println(message);
            try {
                result = LECTOR.nextLine().toLowerCase().charAt(0);
                valid = (c1 + "" + c2).toLowerCase().indexOf(result) != -1;
                if (!valid) {
                    System.out.printf("Error => El carácter debe ser %c o %c\n", c1, c2);
                }
            } catch (NoSuchElementException nsee) {
                System.out.println("No input was provided. Please enter a character.");
            }
        } while (!valid);
        return result;
    }

    /**
     * Method to read a given String by the user, validating the allowed length for the String.
     *
     * @param message for the user (String).
     * @param min     value length for String (int).
     * @param max     value lenght for String (int).
     * @return String introduced by the user.
     */
    public static String requestString(String message, int min, int max) {
        boolean valid = false;
        String result = "";
        do {
            System.out.println(message);
            try {
                result = LECTOR.nextLine();
                valid = result.length() >= min && result.length() <= max;
                if (!valid) {
                    System.out.printf("Error => Minimum length: %d, Maximum length: %d\n", min, max);
                }
            } catch (NoSuchElementException nsee) {
                System.out.println("No input was provided. Please enter a character.");
            }
        } while (!valid);
        return result;
    }

    /**
     * Solicita al usuario ingresar una fecha utilizando el mensaje proporcionado y el formato especificado por SimpleDateFormat(dd/MM/yyyy).
     *
     * @param mensaje El mensaje que se muestra al usuario para solicitar la fecha.
     * @param format  El formato que se utilizará para parsear la fecha.
     * @return La fecha ingresada por el usuario.
     * @throws RuntimeException Si ocurre un error al parsear la fecha o si la entrada no es una fecha válida.
     */
    public static Date solicitarFechaDate(String mensaje, SimpleDateFormat format) { //Añadir fecha minima y fecha maxima o periodo...
        boolean valido = false;
        Date fecha = null;
        do {
            System.out.println(mensaje);
            String fechaStr = LECTOR.nextLine();
            try {
                fecha = format.parse(fechaStr);
                valido = fecha != null;
                if (!valido) {
                    System.out.println("El formato de la fecha no es válido");
                }
            } catch (ParseException pe) {
                System.out.println("La entrada no es válida");
            }
        } while (!valido);
        return fecha;
    }

    /**
     * Solicita al usuario ingresar una fecha dentro de un rango específico, utilizando el mensaje proporcionado y el formato especificado por SimpleDateFormat(dd/MM/yyyy).
     * minDate y maxDate se pasan como en el siguiente ejemplo:
     * Date minDate = null;
     * try{
     * minDate = sdf.parse(date);
     * }catch(ParseException e) {
     * }
     *
     * @param mensaje El mensaje que se muestra al usuario para solicitar la fecha.
     * @param format  El formato que se utilizará para parsear la fecha.
     * @param minDate La fecha mínima permitida para ingresar (inclusive). Puede ser null si no hay una fecha mínima específica.
     * @param maxDate La fecha máxima permitida para ingresar (inclusive). Puede ser null si no hay una fecha máxima específica.
     * @return La fecha ingresada por el usuario dentro del rango especificado.
     * @throws RuntimeException Si ocurre un error al parsear la fecha o si la entrada no es una fecha válida.
     */
    public static Date solicitarFechaDate(String mensaje, SimpleDateFormat format, Date minDate, Date maxDate) {
        boolean valid = false;
        Date fecha = null;
        do {
            System.out.println(mensaje);
            String fechaStr = LECTOR.nextLine();
            try {
                fecha = format.parse(fechaStr);
                if (minDate == null || !fecha.before(minDate) && maxDate == null || !fecha.after(maxDate)) {
                    valid = true;
                } else {
                    System.out.println("La fecha no está dentro del rango");
                }
            } catch (ParseException pe) {
                System.out.println("El formato de la fecha no es válida");
            }
        } while (!valid);
        return fecha;
    }

    /**
     * Solicita al usuario ingresar una fecha utilizando el mensaje proporcionado y el formato especificado por DateTimeFormatter (dd/MM/yyyy).
     *
     * @param mensaje El mensaje que se muestra al usuario para solicitar la fecha.
     * @param format  El formato que se utilizará para parsear la fecha.
     * @return La fecha ingresada por el usuario.
     * @throws RuntimeException Si ocurre un error al parsear la fecha o si la entrada no es una fecha válida.
     */
    public static LocalDate solicitarFechaLocalDate(String mensaje, DateTimeFormatter format) {
        boolean valido = false;
        LocalDate fecha = null;
        do {
            System.out.println(mensaje);
            String fechaStr = LECTOR.nextLine();
            try {
                fecha = LocalDate.parse(fechaStr, format);
                valido = true;
            } catch (DateTimeParseException dtpe) {
                System.out.println("La entrada no es válida");
            }
        } while (!valido);
        return fecha;
    }

    /**
     * Solicita al usuario ingresar una fecha dentro de un rango específico, utilizando el mensaje proporcionado y el formato especificado por DateTimeFormatter (dd/MM/yyyy).
     *
     * @param mensaje El mensaje que se muestra al usuario para solicitar la fecha.
     * @param format  El formato que se utilizará para parsear la fecha.
     * @param minDate La fecha mínima permitida para ingresar (inclusive). Puede ser null si no hay una fecha mínima específica.
     * @param maxDate La fecha máxima permitida para ingresar (inclusive). Puede ser null si no hay una fecha máxima específica.
     * @return La fecha ingresada por el usuario dentro del rango especificado.
     * @throws RuntimeException Si ocurre un error al parsear la fecha o si la entrada no es una fecha válida.
     */
    public static LocalDate solicitarFechaLocalDate(String mensaje, DateTimeFormatter format, LocalDate minDate, LocalDate maxDate) {
        boolean valido = false;
        LocalDate fecha = null;
        do {
            System.out.println(mensaje);
            String fechaStr = LECTOR.nextLine();
            try {
                fecha = LocalDate.parse(fechaStr, format);
                if ((minDate == null || !fecha.isBefore(minDate)) && (maxDate == null || !fecha.isAfter(maxDate))) {
                    valido = true;
                } else {
                    System.out.println("La fecha no está dentro del rango");
                }
            } catch (DateTimeParseException dtpe) {
                System.out.println("El formato de la fecha no es válido");
            }
        } while (!valido);
        return fecha;
    }
}

