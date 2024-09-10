package com.cst.hibernate.app;

import com.cst.hibernate.app.dominio.ClienteDTO;
import com.cst.hibernate.app.entity.Cliente;
import com.cst.hibernate.app.util.ConexionBD;
import jakarta.persistence.EntityManager;

import java.util.List;

public class HibernateQL {

    public static void main(String[] args) {

        EntityManager entityManager = ConexionBD.getEntityManager();

        System.out.println("\n\t ========= CONSULTANDO TODOS LOS REGISTROS =========== ");
        String query = "select c from Cliente c";
        List<Cliente> clientes = entityManager.createQuery(query,Cliente.class).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("\n\t ========= CONSULTANDO UN REGISTRO POR ID =========== ");
        query = "select c from Cliente c where c.id=:id";
        Cliente cliente = entityManager.createQuery(query,Cliente.class)
                .setParameter("id",1L).getSingleResult();
        System.out.println(cliente);

        System.out.println("\n\t ========= CONSULTANDO SOLO EL NOMBRE POR ID =========");
        query = "select c.nombre from Cliente c where c.id=:id";
        String nombre_cliente = entityManager.createQuery(query,String.class)
                .setParameter("id",2L).getSingleResult();
        System.out.printf("\n\t Nombre del cliente con id 2: %s \n",nombre_cliente);

        System.out.println("\n\t ========= CONSULTANDO UN CONJUNTO DE COLUMNAS DE UN SOLO REGISTRO =========");
        query = "select c.id, c.nombre, c.apellido from Cliente c where c.id=:id";
        Object[] objeto_cliente = entityManager.createQuery(query,Object[].class)
                .setParameter("id",1L).getSingleResult();
        String resultado = String.format(
                "\n\t Id: %d, Nombre: %s, Apellido: %s",
                (Long)objeto_cliente[0],
                objeto_cliente[1],
                objeto_cliente[2]
        );
        System.out.println(resultado);

        System.out.println("\n\t ========= CONSULTANDO UN CONJUNTO DE COLUMNAS DE VARIOS REGISTROS =========");
        query = "select c.id, c.nombre, c.apellido from Cliente c";
        List<Object[]> registros = entityManager.createQuery(query,Object[].class).getResultList();
        for(Object[] registro : registros){
            resultado = String.format(
                    "\n\t Id: %d, Nombre: %s, Apellido: %s",
                    (Long)registro[0], registro[1], registro[2]
            );
            System.out.println(resultado);
        }

        System.out.println("\n\t ========= INTANCIANDO DE FORMA DINAMICA UN CONJUNTO DE REGISTROS =========");
        query = "select c.nombre, c.formaPago from Cliente c";
        registros = entityManager.createQuery(query,Object[].class).getResultList();
        for(Object[] registro : registros){
            resultado = String.format(
                    "\n\t Nombre: %s - Forma de pago: %s", registro[0], registro[1]
            );
            System.out.println(resultado);
        }

        System.out.println("\n\t ========= CONSULTA QUE INICIA SOLO ALGUNOS CAMPOS DE UNA CLASE =========");
        // Para el siguiente query agregar un constructor en la clase Cliente
        query = "select new Cliente(c.nombre,c.apellido) from Cliente c";
        clientes = entityManager.createQuery(query,Cliente.class).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("\n\t ========= CONSULTA QUE INICIA SOLO ALGUNOS CAMPOS DE UNA CLASE DTO =========");
        query = "select new com.cst.hibernate.app.dominio.ClienteDTO(c.nombre,c.apellido) from Cliente c";
        List<ClienteDTO> clientesDTO = entityManager.createQuery(query,ClienteDTO.class).getResultList();
        clientesDTO.forEach(System.out::println);



        // Buena practica es cerrar el Entity Manager
        entityManager.close();

    }

}
