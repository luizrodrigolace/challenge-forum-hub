// TopicoUpdateDTO.java
package com.example.forumhub.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicoUpdateDTO {
    @NotNull(message = "Título é obrigatório")
    private String titulo;

    @Size(min = 10, message = "A mensagem deve ter pelo menos 10 caracteres")
    private String mensagem;
}