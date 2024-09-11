package com.cst.hibernate.app.ejemplos;

import com.cst.hibernate.app.model.Usuario;
import com.cst.hibernate.app.repository.Repositorio;
import com.cst.hibernate.app.repository.UsuarioRepositorioImp;
import com.cst.hibernate.app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class ListarUsuariosTest {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Repositorio<Usuario> usuarioRepositorio = new UsuarioRepositorioImp(sessionFactory);
        List<Usuario> usuarios = usuarioRepositorio.listar();
        System.out.println("\n\t LISTANDO USUARIOS: ");
        usuarios.forEach(System.out::print);

        // Contando cuantos usuarios hay:
        String hql = "SELECT COUNT(*) FROM Usuario";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql, Long.class);
        List cuenta = query.getResultList();
        System.out.printf("\n\t Hasta el momento hay %d usuarios",cuenta.get(0));

        System.out.println("\n");
    }

}
