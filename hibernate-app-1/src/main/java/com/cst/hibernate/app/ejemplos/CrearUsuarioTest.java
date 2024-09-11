package com.cst.hibernate.app.ejemplos;

import com.cst.hibernate.app.model.Usuario;
import com.cst.hibernate.app.repository.Repositorio;
import com.cst.hibernate.app.repository.UsuarioRepositorioImp;
import com.cst.hibernate.app.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class CrearUsuarioTest {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Repositorio<Usuario> usuarioRepositorio = new UsuarioRepositorioImp(sessionFactory);

        Usuario usuario = new Usuario();

        System.out.print("\n\t CREANDO UN NUEVO USUARIO: ");
        System.out.print("\n\t Nombre: ");
        usuario.setNombre(entrada.nextLine());
        System.out.print("\n\t Contraseña: ");
        usuario.setContrasena(entrada.nextLine());

        usuarioRepositorio.guardar(usuario);

        System.out.println("\n\t USUARIO CREADO CON EXITO...");

        entrada.close();

    }

}
