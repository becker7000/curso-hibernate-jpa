package com.cst.hibernate.app.model;

import javax.persistence.*;

@Entity
@Table(name="libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idLibro;

    @Column(name="titulo")
    private String titulo;

    @ManyToOne(fetch = FetchType.EAGER) // Cargar automaticamente
    @JoinColumn(name="autor_id")
    private Autor autor;  // ================> AUTOR

    @ManyToOne(fetch = FetchType.EAGER) // Cargar automaticamente
    @JoinColumn(name="editorial_id")
    private Editorial editorial; // =======> EDITORIAL

    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public void mostrarTodo(){
        System.out.printf(
                """
                    +------------------------------------------------+
                    | %s
                    | %s
                    | %s
                    +------------------------------------------------+
                """,this,getAutor(),getEditorial()
        );
    }

    public void mostrarCompacto(){
        System.out.printf(
                """
                    +-------------------------------------------+
                    | Libro: %s
                    | Autor: %s
                    | Editorial: %s
                    +-------------------------------------------+
                """,this.titulo,getAutor().getNombre(),getEditorial().getNombre()
        );
    }

    @Override
    public String toString() {
        return "Libro{" +
                "idLibro=" + idLibro +
                ", titulo='" + titulo + '\'' +
                '}';
    }

}
