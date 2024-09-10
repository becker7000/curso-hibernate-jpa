package com.cst.hibernate.app.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private HibernateUtil(){
        // Para prevenir la instanciación externa
    }

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            try{
                // Crear la configuración de Hibernate
                Configuration configuration = new Configuration().configure(); // Lee hibernate.cfg.xml
                //Construir el objeto de SessionFactory
                sessionFactory = configuration.buildSessionFactory();
            }catch (Exception exception){
                exception.printStackTrace();
                throw new ExceptionInInitializerError("La creación de la fabrica de sesión falló: "+exception);
            }
        }
        return sessionFactory;
    }

    public static void shutdown(){
        if(sessionFactory != null){
            sessionFactory.close();
        }
    }

}
