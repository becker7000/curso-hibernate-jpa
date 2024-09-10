package com.cst.hibernate.app.ejemplos;

import com.cst.hibernate.app.entity.Cliente;
import com.cst.hibernate.app.util.ConexionBD;
import jakarta.persistence.EntityManager;

import java.util.Scanner;

public class HibernateEliminarTest {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        EntityManager entityManager = ConexionBD.getEntityManager();

        try{

            System.out.print("\n\t Escribe el id del Cliente a eliminar: ");
            Long id = Long.parseLong(entrada.nextLine());
            Cliente cliente = entityManager.find(Cliente.class,id);

            entityManager.getTransaction().begin();
            entityManager.remove(cliente);
            entityManager.getTransaction().commit();

            System.out.println("\n\t Cliente eliminado con éxito...");

        }catch (Exception exception){

            entityManager.getTransaction().rollback();
            exception.printStackTrace();

        }finally {

            entityManager.close();
            entrada.close();
        }

    }

}
