package dev.fpsaraiva.apiclientes.model.entity;

import dev.fpsaraiva.apiclientes.model.enums.TipoTelefone;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_telefone")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telefone")
    private Long id;

    @NotBlank
    private String numero;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoTelefone tipo;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(name = "data_cadastro")
    private LocalDateTime criadoEm;

    @Deprecated
    public Telefone() {
    }

    public Telefone(String numero, TipoTelefone tipo, Cliente cliente) {
        this.numero = numero;
        this.tipo = tipo;
        this.cliente = cliente;
        this.criadoEm = LocalDateTime.now();
    }

    public String getNumero() {
        return numero;
    }

    public TipoTelefone getTipo() {
        return tipo;
    }
}
