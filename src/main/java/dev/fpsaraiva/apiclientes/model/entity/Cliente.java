package dev.fpsaraiva.apiclientes.model.entity;

import dev.fpsaraiva.apiclientes.api.dto.TelefoneDTORequest;
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

    @NotBlank
    private String endereco;

    @Size(min = 1)
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.PERSIST)
    private List<Telefone> telefones = new ArrayList<>();

    @Column(name = "data_cadastro")
    private LocalDateTime criadoEm;

    public Cliente(String nome, String documento, String endereco, List<TelefoneDTORequest> telefones) {
        this.nome = nome;
        this.documento = documento;
        this.endereco = endereco;
        telefones.forEach(telefone -> this.telefones.add(telefone.toModel(this)));
        this.criadoEm = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public boolean possuiDocumentoCadastrado(ClienteRepository clienteRepository) {
        return clienteRepository.existsByDocumento(documento);
    }
}
