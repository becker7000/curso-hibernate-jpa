package com.cst.hibernate.app.ejemplos;

import com.cst.hibernate.app.entity.Cliente;
import com.cst.hibernate.app.util.ConexionBD;
import jakarta.persistence.EntityManager;

import java.util.Scanner;

public class HibernateModificarTest {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        EntityManager entityManager = ConexionBD.getEntityManager();

        try{

            System.out.print("\n\t Escribe el id del Cliente a modificar: ");
            Long id = Long.parseLong(entrada.nextLine());

            Cliente cliente = entityManager.find(Cliente.class,id);
            System.out.println(cliente);

            // Primero iniciamos la transacción:
            entityManager.getTransaction().begin();

            System.out.print("\n\t Nuevo nombre: ");
            cliente.setNombre(entrada.nextLine());

            System.out.print("\n\t Nuevo apellido: ");
            cliente.setApellido(entrada.nextLine());

            System.out.print("\n\t Nueva forma de pago: ");
            cliente.setFormaPago(entrada.nextLine());

            // Modificamos en la BD el cliente:
            entityManager.merge(cliente);

            // Cerramos la transacción:
            entityManager.getTransaction().commit();

            System.out.println("\n\t Cliente modificado exitosamente...");

        }catch (Exception exception){

            entityManager.getTransaction().rollback();
            exception.printStackTrace();

        }finally {

            entityManager.close();
            entrada.close();

        }

    }

}
