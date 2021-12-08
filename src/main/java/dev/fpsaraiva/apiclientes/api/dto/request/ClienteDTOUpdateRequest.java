package dev.fpsaraiva.apiclientes.api.dto.request;

public class ClienteDTOUpdateRequest {

    private String nome;

    private String documento;

    public ClienteDTOUpdateRequest(String nome, String documento) {
        this.nome = nome;
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() { return documento; }
}
