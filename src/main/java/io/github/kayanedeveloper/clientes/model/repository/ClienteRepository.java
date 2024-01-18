package io.github.kayanedeveloper.clientes.model.repository;

import io.github.kayanedeveloper.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
