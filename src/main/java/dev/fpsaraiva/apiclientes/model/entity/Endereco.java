package dev.fpsaraiva.apiclientes.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String logradouro;

    @NotNull
    private Integer numero;

    private String complemento;

    @NotBlank
    private String bairro;

    @NotBlank
    private String cidade;

    //TODO: enum de tipos
    private String UF;

    @NotBlank
    private String cep;

    //TODO: limitar 1 principal por cliente
    @NotNull
    private boolean principal;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente idCliente;

    @Column(name = "data_cadastro")
    private LocalDateTime criadoEm;

    public Endereco(String logradouro, Integer numero, String complemento, String bairro, String cidade, String UF,
                    String cep, boolean principal, Cliente idCliente) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.UF = UF;
        this.cep = cep;
        this.principal = principal;
        this.idCliente = idCliente;
        this.criadoEm = LocalDateTime.now();
    }
}
