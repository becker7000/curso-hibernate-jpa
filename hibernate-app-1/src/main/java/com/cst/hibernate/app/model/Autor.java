package com.cst.hibernate.app.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long idAutor;

    @Column(name="nombre")
    private String nombre;

    @OneToMany(mappedBy = "autor",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Libro> libros;

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
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
        return "Autor{" +
                "idAutor=" + idAutor +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
