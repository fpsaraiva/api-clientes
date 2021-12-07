package dev.fpsaraiva.apiclientes.api.dto.request;

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
    @Size(min = 1)
    @Valid
    private List<EnderecoDTORequest> enderecos = new ArrayList<>();

    @NotNull
    @Size(min = 1)
    @Valid
    private List<TelefoneDTORequest> telefones = new ArrayList<>();

    public ClienteDTORequest(String nome, String documento, List<EnderecoDTORequest> enderecos, List<TelefoneDTORequest> telefones) {
        this.nome = nome;
        this.documento = documento;
        this.enderecos.addAll(enderecos);
        this.telefones.addAll(telefones);
    }

    public List<EnderecoDTORequest> getEnderecos() {
        return enderecos;
    }

    public List<TelefoneDTORequest> getTelefones() {
        return telefones;
    }

    public Cliente toModel() {
        return new Cliente(nome, documento, enderecos, telefones);
    }
}
