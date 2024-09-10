package com.cst.hibernate.app.ejemplos;

import com.cst.hibernate.app.entity.Cliente;
import com.cst.hibernate.app.util.ConexionBD;
import jakarta.persistence.EntityManager;

import java.util.Scanner;

public class HibernateCrearTest {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // Crear un registro con Hibernate:
        EntityManager entityManager = ConexionBD.getEntityManager();

        try{

            System.out.print("\n\t Nombre: ");
            String nombre = entrada.nextLine();

            System.out.print("\n\t Apellido: ");
            String apellido = entrada.nextLine();

            System.out.print("\n\t Forma de pago: ");
            String formaPago = entrada.nextLine();

            // Iniciamos una transacción
            entityManager.getTransaction().begin();

            // Y creamos un cliente:
            Cliente cliente = new Cliente();
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setFormaPago(formaPago);

            // Guardamos el registro con persist
            entityManager.persist(cliente);

            // Cerramos la transacción (completa o nada)
            entityManager.getTransaction().commit();

            // Mensaje informativo:
            System.out.println("\n\t Cliente guardado con éxito...");

        }catch(Exception exception){

            entityManager.getTransaction().rollback();
            exception.printStackTrace();
        }finally{
            entityManager.close();
            entrada.close();
        }

    }

}
