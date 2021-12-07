package dev.fpsaraiva.apiclientes.api.dto.request;

public class ClienteDTOUpdateRequest {

    private String nome;

    @Deprecated
    public ClienteDTOUpdateRequest() {
    }

    public ClienteDTOUpdateRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
