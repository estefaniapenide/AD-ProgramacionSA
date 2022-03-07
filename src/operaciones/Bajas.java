/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operaciones;

import Cadenas.Cadenas;
import POJO.Fijo;
import static Sesiones.HBUtil.getSessionFactory;
import org.hibernate.SessionFactory;
import controldata.ControlData;
import java.util.Scanner;
import org.hibernate.Session;

/**
 *
 * @author Estefania
 */
public class Bajas {

    public static void baja(Scanner input) {
        byte op = 0;
        do {
            System.out.println("---------------------------------------------\n"
                    + "\t\tBAJAS\n\n");
            Cadenas.menuEmpleados();
            op = ControlData.leerByte(input);
            switch (op) {
                case 1:
                    fijo(input);
                    break;
                case 2:
                    temporal(input);
                    break;
                case 0:
                    Cadenas.vueltaAnteriorMenu();
                    break;
                default:
                    Cadenas.mesajeDefaultMenu();
                    break;
            }
        } while (op != 0);

    }

    private static void fijo(Scanner input) {
        System.out.println("BAJA EMPLEADO FIJO");
        System.out.println("DNI:");
        String dni = ControlData.leerDni(input);

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        Fijo emplFijo = (Fijo) session.get(Fijo.class, dni);
        session.close();

        if (emplFijo == null) {
            System.out.println("\nEL EMPLEADO FIJO " + dni + " NO EXISTE Y POR LO TANTO NO PUEDE SER BORRADO");
        } else {
            System.out.println("\n" + emplFijo);
            System.out.println("\nEL AUTOR, SUS DATOS Y SUS LIBROS SERÁN BORRADOS (SI ESTOS LIBROS TAMBIÉN TIENEN OTROS AUTORES ESTOS SERÁN BORRADOS CON TODOS SUS LIBROS)\n");
        }

    }

    private static void temporal(Scanner input) {
    }

}
