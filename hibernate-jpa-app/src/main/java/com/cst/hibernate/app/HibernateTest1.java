package com.cst.hibernate.app;

import com.cst.hibernate.app.entity.Cliente;
import com.cst.hibernate.app.util.ConexionBD;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class HibernateTest1 {
    public static void main(String[] args) {

        // Creamos un objeto EntityManager
        EntityManager entityManager = ConexionBD.getEntityManager();

        // Seleccionar todos los objetos c de la Entity Cliente
        // Creamos un query para consultar todos los clientes
        Query query = entityManager.createQuery("select c from Cliente c", Cliente.class);

        // Guardamos una list que pueden entregar el objeto de tipo Query
        List clientes = query.getResultList();

        // Usando Java 8:
        System.out.println("\n\t Lista de productos completa: ");
        clientes.forEach(System.out::println);

        // Cerramos la conexión:
        entityManager.close();

    }
}