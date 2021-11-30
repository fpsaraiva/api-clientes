package dev.fpsaraiva.apiclientes.model.entity;

import dev.fpsaraiva.apiclientes.model.repository.ClienteRepository;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String telefone;

    @Column(name = "data_cadastro")
    private LocalDateTime criadoEm;

    public Cliente(String nome, String documento, String endereco, String telefone) {
        this.nome = nome;
        this.documento = documento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.criadoEm = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public boolean possuiDocumentoCadastrado(ClienteRepository clienteRepository) {
        return clienteRepository.existsByDocumento(documento);
    }
}
