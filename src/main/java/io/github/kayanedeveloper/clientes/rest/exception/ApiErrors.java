package io.github.kayanedeveloper.clientes.rest.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class ApiErrors {

    @Getter
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private final LocalDateTime date;

    @Getter
    private List<String> errors;

    public ApiErrors(List<String> errors) {
        this.errors = errors;
        this.date = LocalDateTime.now();
    }

    public ApiErrors(String message) {
        this.errors = Collections.singletonList(message);
        this.date = LocalDateTime.now();
    }
}
