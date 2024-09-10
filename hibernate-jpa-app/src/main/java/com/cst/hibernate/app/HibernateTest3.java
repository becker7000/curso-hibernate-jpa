package com.cst.hibernate.app;

import com.cst.hibernate.app.entity.Cliente;
import com.cst.hibernate.app.util.ConexionBD;
import jakarta.persistence.EntityManager;

import java.util.Scanner;

public class HibernateTest3 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Long id;

        System.out.print("\n\t Buscar el cliente con id: ");
        id = Long.parseLong(entrada.nextLine());

        // Creamos un objeto EntityManager
        EntityManager entityManager = ConexionBD.getEntityManager();

        // Obtenemos un único cliente con ese id:
        Cliente cliente = entityManager.find(Cliente.class,id);

        // Mostramos el cliente:
        System.out.println(cliente);

        // Cerramos la conexión:
        entityManager.close();


        entrada.close();

    }

}
