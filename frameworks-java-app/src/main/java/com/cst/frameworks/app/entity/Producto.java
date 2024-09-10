package com.cst.frameworks.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto {

    @Id
    @Column(name = "idproducto")
    private int idProducto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private double precio;

    @Column(name = "existencias")
    private int existencias;

    @Column(name = "categoria")
    private String categoria;

    // Getters y setters:

    public int getIdProducto(){
        return idProducto;
    }

    public void setIdProducto(int idProducto){
        this.idProducto = idProducto;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public double getPrecio(){
        return precio;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    public int getExistencias(){
        return existencias;
    }

    public void setExistencias(int exitencias){
        this.existencias = exitencias;
    }

    public String getCategoria(){
        return categoria;
    }

    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", existencias=" + existencias +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
