package com.cst.frameworks.app.service;

import com.cst.frameworks.app.entity.Producto;
import com.cst.frameworks.app.util.ConexionHibernateBD;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductoServiceImp implements ProductoService{

    @Override
    public List<Producto> listar(){

        EntityManager entityManager = ConexionHibernateBD.getEntityManager();
        List<Producto> productos = null;

        try{
            productos = entityManager.createQuery("SELECT p FROM Producto p",Producto.class).getResultList();
        }finally {
            entityManager.close();
        }
        return productos;
    }

}
