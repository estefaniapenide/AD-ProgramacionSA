/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programacionsa;

import Cadenas.Cadenas;
import static Sesiones.HBUtil.getSessionFactory;
import controldata.ControlData;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Scanner;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import operaciones.Altas;
import operaciones.Bajas;
import operaciones.Consultas;
import operaciones.Modificaciones;

/**
 *
 * @author Estefania
 */
public class ProgrmacionSA_Estefania_Penide {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        SessionFactory sessionFactory=getSessionFactory();
        
        byte op=0;
        do{
            Cadenas.menuPrincipal();
            op=ControlData.leerByte(input);
            switch(op){
                case 1:
                    Altas.alta(input);
                    break;
                case 2:
                    Bajas.baja(input);
                    break;
                case 3:
                    Modificaciones.modificacion(input);
                    break;
                case 4:
                    Consultas.consulta(input);
                    break;
                case 0:
                    Cadenas.fin();
                    break;
                default:
                    Cadenas.mesajeDefaultMenu();
                    break;
            }
        }while(op!=0);
        
        getSessionFactory().close();
        input.close();
    }
    
}
