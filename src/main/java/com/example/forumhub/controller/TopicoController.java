package com.example.forumhub.controller;

import com.example.forumhub.dto.TopicoRequestDTO;
import com.example.forumhub.dto.TopicoResponseDTO;
import com.example.forumhub.dto.TopicoUpdateDTO;
import com.example.forumhub.model.Topico;
import com.example.forumhub.repository.CursoRepository;
import com.example.forumhub.repository.TopicoRepository;
import com.example.forumhub.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<TopicoResponseDTO> cadastrar(@RequestBody @Valid TopicoRequestDTO dados, UriComponentsBuilder uriBuilder) {
        var autor = usuarioRepository.findById(dados.getAutorId()).orElseThrow();
        var curso = cursoRepository.findById(dados.getCursoId()).orElseThrow();

        var topico = new Topico();
        topico.setTitulo(dados.getTitulo());
        topico.setMensagem(dados.getMensagem());
        topico.setAutor(autor);
        topico.setCurso(curso);
        topico.setDataCriacao(LocalDateTime.now());
        topico.setStatus(true);

        topicoRepository.save(topico);

        var responseDTO = new TopicoResponseDTO(topico);

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<Page<TopicoResponseDTO>> listar(Pageable paginacao) {
        var page = topicoRepository.findAll(paginacao).map(TopicoResponseDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoResponseDTO> detalhar(@PathVariable Long id) {
        var topico = topicoRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(new TopicoResponseDTO(topico));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid TopicoUpdateDTO dados) {
        var topico = topicoRepository.findById(id).orElseThrow();
        topico.atualizarInformacoes(dados);
        return ResponseEntity.ok(new TopicoResponseDTO(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}