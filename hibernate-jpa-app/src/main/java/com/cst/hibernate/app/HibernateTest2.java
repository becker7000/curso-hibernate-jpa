package com.cst.hibernate.app;

import com.cst.hibernate.app.entity.Cliente;
import com.cst.hibernate.app.util.ConexionBD;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Scanner;

public class HibernateTest2 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        String formaPago;

        System.out.print("\n\t Buscar clientes con forma de pago por: ");
        formaPago = entrada.nextLine();

        // Creamos un objeto EntityManager
        EntityManager entityManager = ConexionBD.getEntityManager();

        // Cambiamos el valor de la consulta:
        Query query = entityManager.createQuery("select c from Cliente c where c.formaPago=?1", Cliente.class);
        query.setParameter(1,formaPago); // Fijamos un parametro de la consulta preparada

        // Casteamos a Cliente el objeto de tipo Object
        // Para un único resultado:
        // Cliente cliente = (Cliente) query.getSingleResult();

        // Obteniendo una lista de elementos con un resultado especifico:
        List<Cliente> clientes_filtrados = query.getResultList();

        // single result da un único resultado...
        // result list da una lista de resultados...

        System.out.println("\n\t Clientes que pagarán con "+formaPago);
        clientes_filtrados.forEach(System.out::println);

        entrada.close();

    }

}
