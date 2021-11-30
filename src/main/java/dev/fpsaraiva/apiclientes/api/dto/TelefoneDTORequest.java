package dev.fpsaraiva.apiclientes.api.dto;

import dev.fpsaraiva.apiclientes.model.entity.Cliente;
import dev.fpsaraiva.apiclientes.model.entity.Telefone;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class TelefoneDTORequest {

    @NotBlank
    @Size(min = 8, max = 14)
    private String numero;

    @NotBlank
    private String tipo;

    public TelefoneDTORequest(String numero, String tipo) {
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
