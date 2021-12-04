package dev.fpsaraiva.apiclientes.api.dto;

import dev.fpsaraiva.apiclientes.model.entity.Cliente;
import dev.fpsaraiva.apiclientes.model.entity.Endereco;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class EnderecoDTORequest {

    @NotBlank
    @Size(max = 150)
    private String endereco;

    @NotBlank
    @Size(max = 50)
    private String cidade;

    public EnderecoDTORequest(String endereco, String cidade) {
        this.endereco = endereco;
        this.cidade = cidade;
    }

    public Endereco toModel(Cliente cliente) {
        return new Endereco(endereco, cidade, cliente);
    }
}
