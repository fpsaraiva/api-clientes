package dev.fpsaraiva.apiclientes.api.dto.request;

import dev.fpsaraiva.apiclientes.model.entity.Cliente;
import dev.fpsaraiva.apiclientes.model.entity.Telefone;
import dev.fpsaraiva.apiclientes.model.enums.TipoTelefone;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TelefoneDTORequest {

    @NotBlank
    @Size(min = 8, max = 14)
    private String numero;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoTelefone tipo;

    public TelefoneDTORequest(String numero, TipoTelefone tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public Telefone toModel(Cliente cliente) {
        return new Telefone(numero, tipo, cliente);
    }
}
