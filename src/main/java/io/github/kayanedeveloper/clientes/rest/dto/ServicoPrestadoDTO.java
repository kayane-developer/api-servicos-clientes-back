package io.github.kayanedeveloper.clientes.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class ServicoPrestadoDTO {

    @NotEmpty(message = "{servicoprestado.descricao.obrigatorio}")
    private String descricao;
    @NotNull(message = "{servicoprestado.preco.obrigatorio}")
    private Double preco;
    @NotEmpty(message = "{servicoprestado.data.obrigatorio}")
    private String data;
    @NotNull(message = "{servicoprestado.cliente.obrigatorio}")
    private Integer idCliente;

}
