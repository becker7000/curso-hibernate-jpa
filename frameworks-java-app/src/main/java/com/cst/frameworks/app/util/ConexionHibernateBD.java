package com.cst.frameworks.app.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexionHibernateBD {

    // Instancia estática del EntityManagerFactory
    private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();

    // Método para construir la EntityManagerFactory
    private static EntityManagerFactory buildEntityManagerFactory(){
        return Persistence.createEntityManagerFactory("unidadDePersistencia");
    }

    // Método que devuelve un EntityManager
    public static EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }

    // Buena practica crear un método que cierre el entityManager (opcional)
    public static void close(){
        if(entityManagerFactory != null && entityManagerFactory.isOpen()){
            entityManagerFactory.close();
        }
    }

}
