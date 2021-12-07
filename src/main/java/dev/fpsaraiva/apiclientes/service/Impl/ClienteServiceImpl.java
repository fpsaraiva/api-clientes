package dev.fpsaraiva.apiclientes.service.Impl;

import dev.fpsaraiva.apiclientes.exception.ApiErroException;
import dev.fpsaraiva.apiclientes.model.entity.Cliente;
import dev.fpsaraiva.apiclientes.model.repository.ClienteRepository;
import dev.fpsaraiva.apiclientes.service.ClienteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public Page<Cliente> getAll(Pageable page) {
        return clienteRepository.findAll(page);
    }

    @Override
    public Optional<Cliente> getById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public void delete(Cliente cliente) {
        if(cliente == null || cliente.getId() == null) {
            throw new IllegalArgumentException("Cliente não pode ser/possuir ID nulo.");
        }
        clienteRepository.delete(cliente);
    }

}
