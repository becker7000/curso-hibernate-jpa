package com.cst.hibernate.app.ejemplos;

import com.cst.hibernate.app.model.Usuario;
import com.cst.hibernate.app.repository.Repositorio;
import com.cst.hibernate.app.repository.UsuarioRepositorioImp;
import com.cst.hibernate.app.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class EliminarUsuarioTest {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Repositorio<Usuario> usuarioRepositorio = new UsuarioRepositorioImp(sessionFactory);
        Long id;

        System.out.println("\n\t ELIMINANDO UN USUARIO ");
        System.out.print("\n\t Escribe el id: ");
        id = Long.parseLong(entrada.nextLine());
        Usuario usuario = usuarioRepositorio.buscarPorId(id);
        System.out.println("\n\t USUARIO ECONTRADO: ");
        System.out.println(usuario);
        usuarioRepositorio.eliminar(id);
        System.out.println("\n\t USUARIO ELIMINADO...");

    }

}
