package io.github.kayanedeveloper.clientes.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    @NotEmpty(message = "{usuario.username.obrigatorio}")
    private String username;

    @NotEmpty(message = "{usuario.password.obrigatorio}")
    private String password;

}
