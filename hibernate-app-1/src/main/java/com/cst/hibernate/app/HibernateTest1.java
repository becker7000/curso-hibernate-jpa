package com.cst.hibernate.app;

import com.cst.hibernate.app.model.Usuario;
import com.cst.hibernate.app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateTest1 {

    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // Creamos una consulta HQL para obtener a todos los usuarios
            String hql = "SELECT u FROM Usuario u";

            // Creamos un objeto para realizar la consulta:
            Query<Usuario> query = session.createQuery(hql, Usuario.class);

            // Listamos los usuarios ejecutando la consulta:
            List<Usuario> usuarios = query.list();

            // Listamos a los usuarios
            System.out.println("\n\t Listando usuarios: ");
            usuarios.forEach(System.out::print);
            System.out.println("\n");
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            HibernateUtil.shutdown(); // Cerramos la fabrica
        }

    }

}
