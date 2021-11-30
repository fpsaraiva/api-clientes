package dev.fpsaraiva.apiclientes.api.resource;

import dev.fpsaraiva.apiclientes.api.dto.ClienteDTORequest;
import dev.fpsaraiva.apiclientes.model.entity.Cliente;
import dev.fpsaraiva.apiclientes.model.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody @Valid ClienteDTORequest dto,
                                    UriComponentsBuilder uriComponentsBuilder) {
        Cliente novoCliente = dto.toModel();
        clienteRepository.save(novoCliente);

        return ResponseEntity.created(uriComponentsBuilder
                .path("/clientes/{id}")
                .buildAndExpand(novoCliente.getId())
                .toUri()).build();
    }
}
