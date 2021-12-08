package dev.fpsaraiva.apiclientes.model.repository;

import dev.fpsaraiva.apiclientes.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
