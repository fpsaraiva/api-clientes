package dev.fpsaraiva.apiclientes.model.repository;

import dev.fpsaraiva.apiclientes.model.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}
