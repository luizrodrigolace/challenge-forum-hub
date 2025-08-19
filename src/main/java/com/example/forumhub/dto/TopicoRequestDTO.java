package com.example.forumhub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicoRequestDTO {

    @NotBlank(message = "O título não pode estar em branco.")
    private String titulo;

    @NotBlank(message = "A mensagem não pode estar em branco.")
    private String mensagem;

    @NotNull(message = "O ID do autor é obrigatório.")
    private Long autorId;

    @NotNull(message = "O ID do curso é obrigatório.")
    private Long cursoId;

}