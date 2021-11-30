package dev.fpsaraiva.apiclientes.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_telefone")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String numero;

    //TODO: enum de tipos
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente idCliente;

    @Column(name = "data_cadastro")
    private LocalDateTime criadoEm;

    public Telefone(String numero, String tipo, Cliente idCliente) {
        this.numero = numero;
        this.tipo = tipo;
        this.idCliente = idCliente;
        this.criadoEm = LocalDateTime.now();
    }
}
