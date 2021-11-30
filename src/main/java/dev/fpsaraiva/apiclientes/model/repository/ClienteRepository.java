package dev.fpsaraiva.apiclientes.model.repository;

import dev.fpsaraiva.apiclientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
