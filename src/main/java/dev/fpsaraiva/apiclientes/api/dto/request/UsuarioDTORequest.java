package dev.fpsaraiva.apiclientes.api.dto.request;

import dev.fpsaraiva.apiclientes.model.entity.Usuario;

import javax.validation.constraints.NotBlank;

public class UsuarioDTORequest {

    @NotBlank(message = "{campo.login.obrigatorio}")
    private String username;

    @NotBlank(message = "{campo.senha.obrigatorio}")
    private String password;

    @Deprecated
    public UsuarioDTORequest() {
    }

    public UsuarioDTORequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Usuario toModel() {
        return new Usuario(username, password);
    }
}
