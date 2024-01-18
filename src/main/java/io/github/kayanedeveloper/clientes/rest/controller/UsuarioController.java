package io.github.kayanedeveloper.clientes.rest.controller;

import io.github.kayanedeveloper.clientes.rest.dto.UsuarioDTO;
import io.github.kayanedeveloper.clientes.rest.exception.UsuarioCadastradoException;
import io.github.kayanedeveloper.clientes.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        try {
            service.salvar(usuarioDTO);
        } catch (UsuarioCadastradoException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

}
