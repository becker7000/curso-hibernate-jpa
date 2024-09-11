package com.cst.hibernate.app.repository;

import com.cst.hibernate.app.model.Usuario;

import java.util.List;

public interface Repositorio <T>{

    List<T> listar();
    T buscarPorId(Long id);
    void guardar(T t);
    void eliminar(Long id);

}
