package io.farma.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.farma.dto.DuracaoCreateDTO;
import io.farma.dto.DuracaoDTO;
import io.farma.entity.Duracao;
import io.farma.mapper.DuracaoMapper;
import io.farma.service.DuracaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/duracoes")
@RequiredArgsConstructor
public class DuracaoController {
    private DuracaoService duracaoService;
    private DuracaoMapper duracaoMapper;
	
	@PostMapping
    public ResponseEntity<DuracaoDTO> create(@Valid @RequestBody DuracaoCreateDTO requestDto) {
		Duracao duracao = duracaoMapper.map(requestDto);
		Duracao duracaoSaved = duracaoService.save(duracao);
		DuracaoDTO responseDto = duracaoMapper.map(duracaoSaved);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
	
	@GetMapping
    public ResponseEntity<List<DuracaoDTO>> getAll() {
        List<DuracaoDTO> result = duracaoService.getAll().stream().map(duracaoMapper::map).collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<DuracaoDTO> findById(@PathVariable UUID id) {
        if (!duracaoService.exists(id)) {
            return ResponseEntity.notFound().build();
        }
        DuracaoDTO dto = duracaoMapper.map(duracaoService.findById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
