package dev.fpsaraiva.apiclientes.api.dto;

import dev.fpsaraiva.apiclientes.model.entity.Telefone;
import dev.fpsaraiva.apiclientes.model.enums.TipoTelefone;

public class TelefoneDTOResponse {

    private String numero;

    private TipoTelefone tipo;

    public TelefoneDTOResponse(Telefone telefone) {
        this.numero = telefone.getNumero();
        this.tipo = telefone.getTipo();
    }

    public String getNumero() {
        return numero;
    }

    public TipoTelefone getTipo() {
        return tipo;
    }
}
