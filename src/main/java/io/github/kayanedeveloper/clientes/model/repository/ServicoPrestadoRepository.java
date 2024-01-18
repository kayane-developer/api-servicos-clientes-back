package io.github.kayanedeveloper.clientes.model.repository;

import io.github.kayanedeveloper.clientes.model.entity.ServicoPrestado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Integer> {

    @Query("SELECT s from ServicoPrestado s JOIN s.cliente c " +
            "WHERE UPPER(c.nome) like UPPER(:nome) AND MONTH(s.data) = :mes")
    public List<ServicoPrestado> findByNomeClienteEMes(String nome, Integer mes);

}
