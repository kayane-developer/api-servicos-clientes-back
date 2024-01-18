package io.github.kayanedeveloper.clientes.service;

import io.github.kayanedeveloper.clientes.model.entity.Cliente;
import io.github.kayanedeveloper.clientes.model.repository.ClienteRepository;
import io.github.kayanedeveloper.clientes.rest.dto.ClienteDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private static final String MSG_CLIENTE_NOT_FOUND = "Cliente não encontrado";

    private final ClienteRepository repository;

    public List<Cliente> obterTodos() {
        return repository.findAll();
    }

    @Transactional
    public Cliente salvarCliente(ClienteDTO clienteDto) {
        final var cliente = dtoToEntity(clienteDto);
        return repository.save(cliente);
    }

    public Cliente buscarOuFalharPorId(Integer idCliente) {
        return repository.findById(idCliente)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, MSG_CLIENTE_NOT_FOUND));
    }

    public void deletarPorId(Integer idCliente) {
        repository.findById(idCliente)
                .ifPresentOrElse(repository::delete,
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND, MSG_CLIENTE_NOT_FOUND);
                        });
    }

    public void atualizar(Integer idCliente, ClienteDTO novosDadosCliente) {
        repository.findById(idCliente)
                .ifPresentOrElse(clienteSalvo -> {
                    final var clienteAtualizado= dtoToEntity(novosDadosCliente);
                    clienteAtualizado.setId(clienteSalvo.getId());
                    clienteAtualizado.setDataCadastro(clienteSalvo.getDataCadastro());
                    repository.save(clienteAtualizado);
                }, () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, MSG_CLIENTE_NOT_FOUND);
                });
    }

    private Cliente dtoToEntity(ClienteDTO clienteDto) {
        return Cliente
                .builder()
                .nome(clienteDto.getNome())
                .cpf(clienteDto.getCpf())
                .build();
    }

}
