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
    @Column(name = "id_endereco")
    private Long id;

    @NotBlank
    private String endereco;

    @NotBlank
    private String cidade;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(name = "data_cadastro")
    private LocalDateTime criadoEm;

    public Endereco(String endereco, String cidade, Cliente cliente) {
        this.endereco = endereco;
        this.cidade = cidade;
        this.cliente = cliente;
        this.criadoEm = LocalDateTime.now();
    }
}
