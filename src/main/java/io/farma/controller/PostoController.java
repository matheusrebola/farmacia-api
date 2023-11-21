package io.farma.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.farma.dto.PostoCreateDTO;
import io.farma.dto.PostoDTO;
import io.farma.entity.Posto;
import io.farma.mapper.PostoMapper;
import io.farma.service.PostoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/postos")
@RequiredArgsConstructor
public class PostoController {
    private PostoService postoService;
    private PostoMapper postoMapper;
	
	@PostMapping
    public ResponseEntity<PostoDTO> create(@Valid @RequestBody PostoCreateDTO requestDto) {
		Posto posto = postoMapper.map(requestDto);
		Posto postoSaved = postoService.save(posto);
		PostoDTO responseDto = postoMapper.map(postoSaved);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
	
	@GetMapping
    public ResponseEntity<List<PostoDTO>> getAll() {
        List<PostoDTO> result = postoService.getAll().stream().map(postoMapper::map).collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<PostoDTO> findById(@PathVariable UUID id) {
        if (!postoService.exists(id)) {
            return ResponseEntity.notFound().build();
        }
        PostoDTO dto = postoMapper.map(postoService.findById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
