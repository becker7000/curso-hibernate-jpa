package com.cst.hibernate.app.ejemplos;

import com.cst.hibernate.app.model.Libro;
import com.cst.hibernate.app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class BibliotecaTest {

    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            // Criteria API para obtener todos los libros con sus autores y editoriales
            String hql = "SELECT l FROM Libro l";
            Query<Libro> query = session.createQuery(hql, Libro.class);
            List<Libro> libros = query.list();
            // Mostrar resultados
            libros.forEach(Libro::mostrarCompacto);

        } catch (Exception e) {
            System.out.println("\n\t ERROR AL LISTAR LIBROS: "+e.getMessage());
        } finally {
            HibernateUtil.shutdown();
        }

    }

}
