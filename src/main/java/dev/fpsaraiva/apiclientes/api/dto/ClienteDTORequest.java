package dev.fpsaraiva.apiclientes.api.dto;

import dev.fpsaraiva.apiclientes.model.entity.Cliente;
import dev.fpsaraiva.apiclientes.validation.ValidDocument;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteDTORequest {

    @NotBlank
    private String nome;

    @NotBlank
    @ValidDocument
    private String documento;

    @NotNull
    private String endereco;

    @NotNull
    private String telefone;

    public ClienteDTORequest(String nome, String documento, String endereco, String telefone) {
        this.nome = nome;
        this.documento = documento;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Cliente toModel() {
        return new Cliente(nome, documento, endereco, telefone);
    }
}
