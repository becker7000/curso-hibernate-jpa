package com.cst.hibernate.app.repository;

import com.cst.hibernate.app.model.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UsuarioRepositorioImp implements Repositorio<Usuario> {

    private SessionFactory sessionFactory;

    public UsuarioRepositorioImp(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Usuario> listar() {
        Session session = sessionFactory.openSession();
        String hql = "SELECT u FROM Usuario u";
        List<Usuario> usuarios = null;
        try{
            usuarios = session.createQuery(hql,Usuario.class).list();
        }catch (Exception exception){
            System.out.println("(LISTAR) ERROR: "+exception.getMessage());
        }finally {
            session.close();
        }
        return usuarios;
    }

    @Override
    public Usuario buscarPorId(Long id) {
        Session session = sessionFactory.openSession();
        Usuario usuario = null;
        try {
            usuario = session.find(Usuario.class,id);
        }catch (Exception exception){
            System.out.println("\n\t (BUSCAR POR ID) ERROR: "+exception.getMessage());
        }finally {
            session.close();
        }
        return usuario;
    }

    @Override
    public void guardar(Usuario usuario) { // Aquí haremos una transacción (modificación a la BD)
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction(); // Iniciamos una transacción
            session.saveOrUpdate(usuario);
            transaction.commit(); // Confirma la transacción como terminada
        }catch (Exception exception){
            if(transaction != null){
                transaction.rollback(); // Deja la BD como estaba
                System.out.println("\n\t (GUARDAR) TRANSACCIÓN NO COMPLETADA: "+exception.getMessage());
            }
        }finally {
            session.close();
        }
    }

    @Override
    public void eliminar(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            Usuario usuario = buscarPorId(id);
            if(usuario != null){
                session.delete(usuario);
            }
            transaction.commit();
        }catch (Exception exception){
            if(transaction != null){
                transaction.rollback();
                System.out.println("\n\t (ELIMINAR) TRANSACCIÓN NO COMPLETADA: "+exception.getMessage());
            }
        }finally {
            session.close();
        }
    }
}
