package io.github.kayanedeveloper.clientes.service;

import io.github.kayanedeveloper.clientes.model.entity.Usuario;
import io.github.kayanedeveloper.clientes.model.repository.UsuarioRepository;
import io.github.kayanedeveloper.clientes.rest.dto.UsuarioDTO;
import io.github.kayanedeveloper.clientes.rest.exception.UsuarioCadastradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository repository;

    public void salvar(UsuarioDTO dto) {
        final var username = dto.getUsername();
        final var usuarioExiste = repository.existsByUsername(username);
        if(usuarioExiste) {
            throw new UsuarioCadastradoException(username);
        }

        final var usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setPassword(dto.getPassword());

        repository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final var usuario = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Login não encontrado."));
        return User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles("USER")
                .build();
    }

}
