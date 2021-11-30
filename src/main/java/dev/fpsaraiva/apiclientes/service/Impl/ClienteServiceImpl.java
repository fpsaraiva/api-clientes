package dev.fpsaraiva.apiclientes.service.Impl;

import dev.fpsaraiva.apiclientes.exception.ApiErroException;
import dev.fpsaraiva.apiclientes.model.entity.Cliente;
import dev.fpsaraiva.apiclientes.model.repository.ClienteRepository;
import dev.fpsaraiva.apiclientes.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente save(Cliente cliente) {

        if(cliente.possuiDocumentoCadastrado(clienteRepository)) {
            throw new ApiErroException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "Não é possível cadastrar mais de um cliente com o mesmo documento.");
        }

        return clienteRepository.save(cliente);
    }
}
