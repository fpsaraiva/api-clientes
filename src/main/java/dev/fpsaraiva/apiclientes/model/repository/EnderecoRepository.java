package dev.fpsaraiva.apiclientes.model.repository;

import dev.fpsaraiva.apiclientes.model.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
