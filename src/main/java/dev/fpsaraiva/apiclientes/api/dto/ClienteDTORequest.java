package dev.fpsaraiva.apiclientes.api.dto;

import dev.fpsaraiva.apiclientes.model.entity.Cliente;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class ClienteDTORequest {

    @NotBlank
    private String nome;

    @NotBlank
    //@ValidDocument
    private String documento;

    @NotNull
    private String endereco;

    @NotNull
    @Size(min = 1)
    @Valid
    private List<TelefoneDTORequest> telefones = new ArrayList<>();;

    public ClienteDTORequest(String nome, String documento, String endereco, List<TelefoneDTORequest> telefones) {
        this.nome = nome;
        this.documento = documento;
        this.endereco = endereco;
        this.telefones.addAll(telefones);
    }

    public List<TelefoneDTORequest> getTelefones() {
        return telefones;
    }

    public Cliente toModel() {
        return new Cliente(nome, documento, endereco, telefones);
    }
}
