package com.cst.hibernate.app.repository;

import com.cst.hibernate.app.entity.Cliente;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ClienteRepositorioImp implements CrudRepository<Cliente> {

    private EntityManager entityManager;

    public ClienteRepositorioImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Cliente> listar() {
        // El manejo de transacciones se hace fuera de la implementación
        return entityManager.createQuery("select c from Cliente c",Cliente.class).getResultList();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return entityManager.find(Cliente.class,id);
    }

    @Override
    public void guardar(Cliente cliente) {
        if(cliente.getId() != null && cliente.getId()>0){ // Si ya existe, se modifica
            entityManager.merge(cliente);
        }else { // Si no, entonces se inserta el registro
            entityManager.persist(cliente);
        }
    }

    @Override
    public void eliminar(Long id) {
        Cliente cliente = buscarPorId(id);
        entityManager.remove(cliente);
    }

}
