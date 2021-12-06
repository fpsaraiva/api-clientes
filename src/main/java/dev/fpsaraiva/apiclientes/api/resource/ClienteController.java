package dev.fpsaraiva.apiclientes.api.resource;

import dev.fpsaraiva.apiclientes.api.dto.ClienteDTORequest;
import dev.fpsaraiva.apiclientes.api.dto.ClienteDTOResponse;
import dev.fpsaraiva.apiclientes.exception.ApiErroException;
import dev.fpsaraiva.apiclientes.model.entity.Cliente;
import dev.fpsaraiva.apiclientes.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody @Valid ClienteDTORequest dto,
                                    UriComponentsBuilder uriComponentsBuilder) {
        Cliente novoCliente = dto.toModel();
        novoCliente = clienteService.save(novoCliente);

        return ResponseEntity.created(uriComponentsBuilder
                .path("/clientes/{id}")
                .buildAndExpand(novoCliente.getId())
                .toUri()).build();
    }

    @GetMapping("/{id}")
    public ClienteDTOResponse getClientById(@PathVariable Long id) {
        try {
            Cliente clienteBuscado = clienteService.getById(id).get();
            return new ClienteDTOResponse(clienteBuscado);
        } catch (NoSuchElementException ex) {
            throw new ApiErroException(HttpStatus.NOT_FOUND, "Não foi encontrado cliente com o ID informado.");
        }
    }

    //TODO: listar todos clientes

    //TODO: atualizar cliente

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        try {
            Cliente clienteBuscado = clienteService.getById(id).get();
            clienteService.delete(clienteBuscado);
        } catch (NoSuchElementException ex) {
            throw new ApiErroException(HttpStatus.NOT_FOUND, "Não foi encontrado cliente com o ID informado.");
        }
    }
}
