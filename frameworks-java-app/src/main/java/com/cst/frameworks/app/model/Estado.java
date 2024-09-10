package com.cst.frameworks.app.model;

public class Estado {

    private String estadoAbreviado;
    private String nombreEstado;

    public Estado(String estadoAbreviado,String nombreEstado){
        this.estadoAbreviado = estadoAbreviado;
        this.nombreEstado = nombreEstado;
    }

    public String getEstadoAbreviado(){
        return estadoAbreviado;
    }

    public void setEstadoAbreviado(String estadoAbreviado){
        this.estadoAbreviado = estadoAbreviado;
    }

    public String getNombreEstado(){
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado){
        this.nombreEstado = nombreEstado;
    }

    @Override
    public String toString(){
        return getEstadoAbreviado();
    }

}
