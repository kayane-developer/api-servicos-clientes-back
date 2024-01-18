package io.github.kayanedeveloper.clientes.service;

import io.github.kayanedeveloper.clientes.model.entity.ServicoPrestado;
import io.github.kayanedeveloper.clientes.model.repository.ServicoPrestadoRepository;
import io.github.kayanedeveloper.clientes.rest.dto.ServicoPrestadoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicoPrestadoService {

    private final ClienteService clienteService;
    private final ServicoPrestadoRepository repository;

    public ServicoPrestado salvar(ServicoPrestadoDTO dto) {
        final var data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        final var cliente = clienteService.buscarOuFalharPorId(dto.getIdCliente());
        final var servicoPrestado = new ServicoPrestado();
        servicoPrestado.setDescricao(dto.getDescricao());
        servicoPrestado.setData(data);
        servicoPrestado.setCliente(cliente);
        servicoPrestado.setValor(BigDecimal.valueOf(dto.getPreco()));

        return repository.save(servicoPrestado);
    }

    public List<ServicoPrestado> pesquisarPorClienteEMes(String nome, Integer mes) {
        return repository.findByNomeClienteEMes("%" + nome + "%", mes);
    }

}
