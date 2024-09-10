package com.cst.hibernate.app;

import com.cst.hibernate.app.entity.Cliente;
import com.cst.hibernate.app.service.ClienteService;
import com.cst.hibernate.app.service.ClienteServiceImp;
import com.cst.hibernate.app.util.ConexionBD;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class HibernateCrudTest {

    public static void main(String[] args) {

        EntityManager entityManager = ConexionBD.getEntityManager();
        ClienteService clienteService = new ClienteServiceImp(entityManager);
        Scanner entrada = new Scanner(System.in);

        int opcion=0;

        while(opcion!=6){

            do{
                System.out.print(
                        """
                            +-----------------MENÚ---------------+
                            | 1. Listar clientes                 |
                            | 2. Buscar un cliente por id        |
                            | 3. Crear un cliente nuevo          |
                            | 4. Modificar un cliente existente  |
                            | 5. Eliminar un cliente             |
                            | 6. Salir                           |
                            +------------------------------------+
                        """
                );
                System.out.print("\n\t Opción> ");
                opcion = Integer.parseInt(entrada.nextLine());
            }while (opcion<1 || opcion>6);

            switch (opcion){
                case 1 -> {
                    List<Cliente> clientes = clienteService.listar();
                    System.out.println("\n\t => LISTANDO CLIENTES: ");
                    clientes.forEach(System.out::println);
                }
                case 2 -> {
                    Long id;
                    System.out.println("\n\t => BUSCANDO UN CLIENTE POR ID: ");
                    System.out.print("\n\t Escribe el id del cliente: ");
                    id = Long.parseLong(entrada.nextLine());
                    // Usando Java 8:
                    Optional<Cliente> cliente = clienteService.buscarPorId(id);
                    cliente.ifPresent(System.out::println);
                }
                case 3 -> {
                    System.out.println("\n\t => CREANDO UN CLIENTE NUEVO: ");
                    Cliente cliente = new Cliente(); // Se crea un cliente vacío...
                    System.out.print("\n\t Nombre: ");
                    cliente.setNombre(entrada.nextLine());
                    System.out.print("\n\t Apellido: ");
                    cliente.setApellido(entrada.nextLine());
                    System.out.print("\n\t Forma de pago: ");
                    cliente.setFormaPago(entrada.nextLine());
                    clienteService.guardar(cliente);
                    System.out.println("\n\t Cliente creado con éxito...");
                }
                case 4 -> {
                    System.out.println("\n\t => MODIFICANDO UN CLIENTE EXISTENTE: ");
                    System.out.print("\n\t Escribe el id del cliente a modificar: ");
                    Long id = Long.parseLong(entrada.nextLine());
                    Optional<Cliente> cliente = clienteService.buscarPorId(id);
                    if(cliente.isPresent()){
                        System.out.print("\n\t Nuevo nombre: ");
                        cliente.get().setNombre(entrada.nextLine());
                        System.out.print("\n\t Nuevo apellido: ");
                        cliente.get().setApellido(entrada.nextLine());
                        System.out.print("\n\t Nueva forma de pago: ");
                        cliente.get().setFormaPago(entrada.nextLine());
                        clienteService.guardar(cliente.get());
                        System.out.println("\n\t Cliente modificado con éxito...");
                    }else {
                        System.out.println("\n\t Cliente no encontrado...");
                    }
                }
                case 5 -> {
                    System.out.println("\n\t => ELIMINANDO UN CLIENTE POR ID: ");
                    System.out.print("\n\t Escribe el id del cliente a eliminar: ");
                    Long id = Long.parseLong(entrada.nextLine());
                    Optional<Cliente> cliente = clienteService.buscarPorId(id);
                    if(cliente.isPresent()){
                        clienteService.eliminar(id);
                    }else {
                        System.out.println("\n\t Cliente no encontrado...");
                    }
                }
                case 6 -> {
                    System.out.println("\n\t => SALIENDO DEL GESTOR DE CLIENTES...");
                }
            }
        }

        entrada.close();
        entityManager.close();

    }

}
