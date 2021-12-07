package dev.fpsaraiva.apiclientes.api.resource;

import dev.fpsaraiva.apiclientes.api.dto.ClienteDTORequest;
import dev.fpsaraiva.apiclientes.api.dto.ClienteDTOResponse;
import dev.fpsaraiva.apiclientes.exception.ApiErroException;
import dev.fpsaraiva.apiclientes.model.entity.Cliente;
import dev.fpsaraiva.apiclientes.service.ClienteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity<?> createCliente(@RequestBody @Valid ClienteDTORequest dto,
                                    UriComponentsBuilder uriComponentsBuilder) {
        Cliente novoCliente = dto.toModel();
        novoCliente = clienteService.save(novoCliente);

        return ResponseEntity.created(uriComponentsBuilder
                .path("/clientes/{id}")
                .buildAndExpand(novoCliente.getId())
                .toUri()).build();
    }

    @GetMapping
    //Atributos do @PegeableDefault que podem ser definidos na requisição: size (número de resultados por página) e page (número da pagina)
    public ResponseEntity<?> getClientes(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable page) {
        Page<Cliente> clientesCadastrados = clienteService.getAll(page);
        return ResponseEntity.ok(ClienteDTOResponse.toList(clientesCadastrados).getContent());
    }

    @GetMapping("/{id}")
    public ClienteDTOResponse getClienteById(@PathVariable Long id) {
        try {
            Cliente clienteBuscado = clienteService.getById(id).get();
            return new ClienteDTOResponse(clienteBuscado);
        } catch (NoSuchElementException ex) {
            throw new ApiErroException(HttpStatus.NOT_FOUND, "Não foi encontrado cliente com o ID informado.");
        }
    }

    //TODO: atualizar cliente

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCliente(@PathVariable Long id) {
        try {
            Cliente clienteBuscado = clienteService.getById(id).get();
            clienteService.delete(clienteBuscado);
        } catch (NoSuchElementException ex) {
            throw new ApiErroException(HttpStatus.NOT_FOUND, "Não foi encontrado cliente com o ID informado.");
        }
    }
}
