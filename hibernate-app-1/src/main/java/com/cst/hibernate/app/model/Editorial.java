package com.cst.hibernate.app.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "editoriales")
public class Editorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long idEditorial;

    @Column(name="nombre")
    private String nombre;

    @OneToMany(mappedBy = "editorial",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Libro> libros;

    public Long getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(Long idEditorial) {
        this.idEditorial = idEditorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Libro> getLibros() {
        return libros;
    }

    public void setLibros(Set<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Editorial{" +
                "idEditorial=" + idEditorial +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}