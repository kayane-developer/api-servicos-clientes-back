package io.github.kayanedeveloper.clientes.rest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class ClienteDTO {

    @NotEmpty(message = "{cliente.nome.obrigatorio}")
    private String nome;

    @NotEmpty(message = "{cliente.cpf.obrigatorio}")
    @CPF(message = "{cliente.cpf.invalido}")
    private String cpf;

}
