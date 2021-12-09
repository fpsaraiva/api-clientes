package dev.fpsaraiva.apiclientes.api.resource;

import dev.fpsaraiva.apiclientes.api.dto.request.UsuarioDTORequest;
import dev.fpsaraiva.apiclientes.exception.UsuarioCadastradoException;
import dev.fpsaraiva.apiclientes.model.entity.Usuario;
import dev.fpsaraiva.apiclientes.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid UsuarioDTORequest dto) {
        try {
            Usuario novoUsuario = dto.toModel();
            usuarioService.salvar(novoUsuario);
        } catch (UsuarioCadastradoException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }
}
