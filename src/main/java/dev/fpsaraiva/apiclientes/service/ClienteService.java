package dev.fpsaraiva.apiclientes.service;

import dev.fpsaraiva.apiclientes.model.entity.Cliente;

import java.util.Optional;

public interface ClienteService {

    Cliente save(Cliente cliente);

    Optional<Cliente> getById(Long id);

    void delete(Cliente cliente);
}
