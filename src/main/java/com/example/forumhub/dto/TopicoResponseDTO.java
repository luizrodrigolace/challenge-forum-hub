package com.example.forumhub.dto;

import com.example.forumhub.model.Topico;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TopicoResponseDTO {

    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String autor;
    private String curso;

    public TopicoResponseDTO(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
        this.autor = topico.getAutor().getNome();
        this.curso = topico.getCurso().getNome();
    }
}