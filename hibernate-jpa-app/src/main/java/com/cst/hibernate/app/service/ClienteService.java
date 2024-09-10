package com.cst.hibernate.app.service;

import com.cst.hibernate.app.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<Cliente> listar();
    // Es Optional porque podría no existir el cliente...
    Optional<Cliente> buscarPorId(Long id);
    void guardar(Cliente cliente);
    void eliminar(Long id);

}
