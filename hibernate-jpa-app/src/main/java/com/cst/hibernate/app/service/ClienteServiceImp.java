package com.cst.hibernate.app.service;

import com.cst.hibernate.app.entity.Cliente;
import com.cst.hibernate.app.repository.ClienteRepositorioImp;
import com.cst.hibernate.app.repository.CrudRepository;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class ClienteServiceImp implements ClienteService {

    private EntityManager entityManager;
    private CrudRepository<Cliente> repository;

    public ClienteServiceImp(EntityManager entityManager) {
        this.entityManager = entityManager;
        repository = new ClienteRepositorioImp(entityManager);
    }

    @Override
    public List<Cliente> listar() {
        return repository.listar();
    }

    @Override
    public Optional<Cliente> buscarPorId(Long id) {
        // Algo que podría ser nulo.
        return Optional.ofNullable(repository.buscarPorId(id));
    }

    @Override
    public void guardar(Cliente cliente) {
        try{
            entityManager.getTransaction().begin();
            repository.guardar(cliente); // Usando un método personalizado
            entityManager.getTransaction().commit();
        }catch (Exception exception){
            entityManager.getTransaction().rollback();
            exception.printStackTrace();
        }
    }

    @Override
    public void eliminar(Long id) {
        try{
            entityManager.getTransaction().begin();
            repository.eliminar(id); // Usando un método personalizado
            entityManager.getTransaction().commit();
        }catch (Exception exception){
            entityManager.getTransaction().rollback();
            exception.printStackTrace();
        }
    }
}
