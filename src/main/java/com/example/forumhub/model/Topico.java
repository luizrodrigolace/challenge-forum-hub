// Topico.java
package com.example.forumhub.model;

import com.example.forumhub.dto.TopicoUpdateDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private Boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public void atualizarInformacoes(TopicoUpdateDTO dados) {
        if (dados.getTitulo() != null && !dados.getTitulo().trim().isEmpty()) {
            this.titulo = dados.getTitulo();
        }
        if (dados.getMensagem() != null && !dados.getMensagem().trim().isEmpty()) {
            this.mensagem = dados.getMensagem();
        }
    }
}