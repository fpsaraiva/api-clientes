package dev.fpsaraiva.apiclientes.api.resource;

import dev.fpsaraiva.apiclientes.api.dto.request.UsuarioDTORequest;
import dev.fpsaraiva.apiclientes.model.entity.Usuario;
import dev.fpsaraiva.apiclientes.model.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid UsuarioDTORequest dto) {
        Usuario novoUsuario = dto.toModel();
        usuarioRepository.save(novoUsuario);
    }
}
