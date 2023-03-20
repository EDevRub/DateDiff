package datediff;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author rubio
 */
public class DateDiff {

    /*
    * Crea una función que calcule y retorne cuántos días hay entre dos cadenas
    * de texto que representen fechas.
    * - Una cadena de texto que representa una fecha tiene el formato "dd/MM/yyyy".
    * - La función recibirá dos String y retornará un Int.
    * - La diferencia en días será absoluta (no importa el orden de las fechas).
    * - Si una de las dos cadenas de texto no representa una fecha correcta se
    *   lanzará una excepción.
     */
    public static void main(String[] args) {
        Scanner text = new Scanner(System.in);
        String f1 = "00/00/0000";
        String f2 = "00/00/0000";
        int diferenciaDias = 0;

        System.out.print("Ingrese fecha Uno: ");
        f1 = text.nextLine();
        System.out.print("Ingrese fecha Dos: ");
        f2 = text.nextLine();

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fechaUno = formato.parse(f1);
            Date fechaDos = formato.parse(f2);

            diferenciaDias = fechaDiferencia(fechaUno, fechaDos);

            System.out.println("La diferencia entre ambas fechas es de " + diferenciaDias + " Dias");
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
        }
    }

    public static int fechaDiferencia(Date fechaUno, Date fechaDos) {
        LocalDate f1 = fechaUno.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate f2 = fechaDos.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        long dif = ChronoUnit.DAYS.between(f1, f2);

        return Integer.parseInt(String.valueOf(dif));
    }

}
