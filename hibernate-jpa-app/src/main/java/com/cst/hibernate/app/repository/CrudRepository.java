package com.cst.hibernate.app.repository;

import java.util.List;

public interface CrudRepository <T>{

    List<T> listar();
    T buscarPorId(Long id);
    void guardar(T t);
    void eliminar(Long id);

}
