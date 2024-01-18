package io.github.kayanedeveloper.clientes.rest.controller;

import io.github.kayanedeveloper.clientes.model.entity.ServicoPrestado;
import io.github.kayanedeveloper.clientes.rest.dto.ServicoPrestadoDTO;
import io.github.kayanedeveloper.clientes.service.ServicoPrestadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/servicos-prestados")
public class ServicoPrestadoController {

    private final ServicoPrestadoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar(@RequestBody @Valid ServicoPrestadoDTO servicoPrestadoDTO) {
        return service.salvar(servicoPrestadoDTO);
    }

    @GetMapping
    public List<ServicoPrestado> pesquisar(@RequestParam(value = "nome", required = false, defaultValue = "") String nome,
                                           @RequestParam(value = "mes", required = false) Integer mes) {
        return service.pesquisarPorClienteEMes(nome, mes);
    }

}
