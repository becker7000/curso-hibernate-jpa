package com.cst.hibernate.app.ejemplos;

import com.cst.hibernate.app.model.Usuario;
import com.cst.hibernate.app.repository.Repositorio;
import com.cst.hibernate.app.repository.UsuarioRepositorioImp;
import com.cst.hibernate.app.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class ModificarUsuarioTest { // Primero hacer BuscarUsuarioPorIdTest

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Repositorio<Usuario> usuarioRepositorio = new UsuarioRepositorioImp(sessionFactory);
        Long id;

        System.out.println("\n\t MODIFICANDO USUARIO: ");
        System.out.println("\n\t Escribe el id: ");
        id = Long.parseLong(entrada.nextLine());
        Usuario usuario = usuarioRepositorio.buscarPorId(id);
        System.out.println("\n\t USUARIO ENCONTRADO: ");
        System.out.println(usuario);
        System.out.print("\n\t => Nuevo nombre: ");
        usuario.setNombre(entrada.nextLine());
        System.out.print("\n\t => Nueva contraseña: ");
        usuario.setContrasena(entrada.nextLine());
        usuarioRepositorio.guardar(usuario);
        System.out.println("\n\t USUARIO MODIFICADO CON ÉXITO");

        entrada.close();

    }

}
