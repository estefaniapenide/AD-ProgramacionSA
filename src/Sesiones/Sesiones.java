/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sesiones;

import static Sesiones.HBUtil.getSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Estefania
 */
public class Sesiones {

    public static void guardar(Object object) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        session.close();
    }

    public static void actualizar(Object object) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        session.close();
    }

    public static void borrar(Object object) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        session.close();
    }

}
