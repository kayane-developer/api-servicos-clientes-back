package io.github.kayanedeveloper.clientes.rest.controller;

import io.github.kayanedeveloper.clientes.model.entity.Cliente;
import io.github.kayanedeveloper.clientes.rest.dto.ClienteDTO;
import io.github.kayanedeveloper.clientes.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @GetMapping()
    public List<Cliente> obterTodos() {
        return service.obterTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody @Valid ClienteDTO clienteDto) {
        return service.salvarCliente(clienteDto);
    }

    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable("id") Integer idCliente) {
        return service.buscarOuFalharPorId(idCliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPorId(@PathVariable("id") Integer idCliente) {
        service.deletarPorId(idCliente);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable("id") Integer idCliente, @RequestBody @Valid ClienteDTO clienteAtualizado) {
        service.atualizar(idCliente, clienteAtualizado);
    }

}
