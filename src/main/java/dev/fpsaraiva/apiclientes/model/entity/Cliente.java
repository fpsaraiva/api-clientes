package dev.fpsaraiva.apiclientes.model.entity;

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

    //TODO: documento (cpf/cnpj) não pode ser duplicado
    private String documento;

    //TODO: definir relacionamento
    private Endereco endereco;

    //TODO: definir relacionamento
    private Telefone telefone;

    @Column(name = "data_cadastro")
    private LocalDateTime criadoEm;

    public Cliente(String nome, String documento, Endereco endereco, Telefone telefone) {
        this.nome = nome;
        this.documento = documento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.criadoEm = LocalDateTime.now();
    }
}
