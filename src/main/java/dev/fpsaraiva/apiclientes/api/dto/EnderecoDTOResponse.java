package dev.fpsaraiva.apiclientes.api.dto;

import dev.fpsaraiva.apiclientes.model.entity.Endereco;

public class EnderecoDTOResponse {

    private String endereco;

    private String cidade;

    public EnderecoDTOResponse(Endereco endereco) {
        this.endereco = endereco.getEndereco();
        this.cidade = endereco.getCidade();
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCidade() {
        return cidade;
    }
}
