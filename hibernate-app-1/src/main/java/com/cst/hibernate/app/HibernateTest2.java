package com.cst.hibernate.app;

import com.cst.hibernate.app.model.Producto;
import com.cst.hibernate.app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateTest2 {

    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // Creamos una consulta HQL para obtener a todos los usuarios
            String hql = "SELECT p FROM Producto p";

            // Creamos un objeto para realizar la consulta:
            Query<Producto> query = session.createQuery(hql,Producto.class);

            // Listamos los usuarios ejecutando la consulta:
            List<Producto> productos = query.list();

            // Listamos a los usuarios
            System.out.println("\n\t Listando usuarios: ");
            productos.forEach(System.out::print);
            System.out.println("\n");

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            HibernateUtil.shutdown(); // Cerramos la fabrica
        }

    }

}
