package dev.fpsaraiva.apiclientes.model.entity;

import dev.fpsaraiva.apiclientes.api.dto.request.EnderecoDTORequest;
import dev.fpsaraiva.apiclientes.api.dto.request.TelefoneDTORequest;
import dev.fpsaraiva.apiclientes.model.repository.ClienteRepository;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String documento;

    //Anotação desativada para realização de testes no frontend
    //@Size(min = 1)
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();

    //Anotação desativada para realização de testes no frontend
    //@Size(min = 1)
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Telefone> telefones = new ArrayList<>();

    @Column(name = "data_cadastro")
    private LocalDateTime criadoEm;

    @Deprecated
    public Cliente() {
    }

    public Cliente(String nome, String documento, List<EnderecoDTORequest> enderecos, List<TelefoneDTORequest> telefones) {
        this.nome = nome;
        this.documento = documento;
        enderecos.forEach(endereco -> this.enderecos.add(endereco.toModel(this)));
        telefones.forEach(telefone -> this.telefones.add(telefone.toModel(this)));
        this.criadoEm = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDocumento(String documento) { this.documento = documento; }

    public boolean possuiDocumentoCadastrado(ClienteRepository clienteRepository) {
        return clienteRepository.existsByDocumento(documento);
    }
}
