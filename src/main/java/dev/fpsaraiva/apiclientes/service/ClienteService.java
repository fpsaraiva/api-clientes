package dev.fpsaraiva.apiclientes.service;

import dev.fpsaraiva.apiclientes.model.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ClienteService {

    Cliente save(Cliente cliente);

    Page<Cliente> getAll(Pageable page);

    Optional<Cliente> getById(Long id);

    Cliente update(Cliente cliente);

    void delete(Cliente cliente);
}
