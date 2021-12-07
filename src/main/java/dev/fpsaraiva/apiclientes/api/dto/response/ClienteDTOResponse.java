package dev.fpsaraiva.apiclientes.api.dto.response;

import dev.fpsaraiva.apiclientes.model.entity.Cliente;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteDTOResponse {

    private String nome;

    private String documento;

    private List<EnderecoDTOResponse> enderecos;

    private List<TelefoneDTOResponse> telefones;

    public ClienteDTOResponse(Cliente cliente) {
        this.nome = cliente.getNome();
        this.documento = cliente.getDocumento();
        this.enderecos = cliente.getEnderecos()
                .stream()
                .map(EnderecoDTOResponse::new)
                .collect(Collectors.toList());
        this.telefones = cliente.getTelefones()
                .stream()
                .map(TelefoneDTOResponse::new)
                .collect(Collectors.toList());
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

/*  Ajuste realizado para teste de integração com front (listagem de clientes)
    public List<EnderecoDTOResponse> getEnderecos() {
        return enderecos;
    }

    public List<TelefoneDTOResponse> getTelefones() {
        return telefones;
    }*/

    public static Page<ClienteDTOResponse> toList(Page<Cliente> page) { return  page.map(ClienteDTOResponse::new); }
}
