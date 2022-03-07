/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operaciones;

import Cadenas.Cadenas;
import POJO.Empleado;
import POJO.Empresa;
import POJO.Producto;
import static Sesiones.HBUtil.getSessionFactory;
import org.hibernate.SessionFactory;
import controldata.ControlData;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;

/**
 *
 * @author Estefania
 */
public class Consultas {

    public static void consulta(Scanner input) {
        byte op = 0;
        do {
            Cadenas.menuConsultas();
            op = ControlData.leerByte(input);
            switch (op) {
                case 1:
                    empresasEmpleados(input);
                    break;
                case 2:
                    productosEmpresa(input);
                    break;
                case 3:
                    empleadoTemporalNomina(input);
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

    public static void empresasEmpleados(Scanner input) {

//        System.out.println("CIF DE LA EMPRESA:");
//        String cif = ControlData.leerString(input);
//
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        System.out.println("\nLISTA DE EMPLEADOS DE LA EMPRESA:\n");
//        List<Empleado> empleados = session.createNamedQuery("empleadosEmpresa").setParameter("cif", cif).list();
//        for (Empleado empleado : empleados) {
//            System.out.println(empleado);
//        }
//
//        session.close();

        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        List<Empresa> totalEmp = session.createNamedQuery("empresas").list();

        for (Empresa empresa : totalEmp) {
            System.out.println("\tEMPRESA "+empresa);
            System.out.println("\tLSITA DE EMPLEADOS:");
            for (Empleado empleado : empresa.getEmpleados()) {
                System.out.println(empleado);
            }
            System.out.println("-------------------------");
        }

        session.close();
    }

    public static void productosEmpresa(Scanner input) {
        
        System.out.println("CIF DE LA EMPRESA:");
        String cif = ControlData.leerString(input);

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        System.out.println("\nLISTA DE PRODUCTOS DE LA EMPRESA:\n");
        List<Producto> productos = session.createNamedQuery("productosEmpresa").setParameter("cif", cif).list();
        for (Producto producto : productos) {
            System.out.println(producto);
        }

        session.close();
    }

    public static void empleadoTemporalNomina(Scanner input) {
    }

}
