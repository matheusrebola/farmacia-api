package io.farma.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.farma.dto.EnderecoCreateDTO;
import io.farma.dto.EnderecoDTO;
import io.farma.entity.Endereco;
import io.farma.mapper.EnderecoMapper;
import io.farma.service.EnderecoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/enderecos")
@RequiredArgsConstructor
public class EnderecoController {
    private EnderecoService enderecoService;
    private EnderecoMapper enderecoMapper;
	
	@PostMapping
    public ResponseEntity<EnderecoDTO> create(@Valid @RequestBody EnderecoCreateDTO requestDto) {
		Endereco endereco = enderecoMapper.map(requestDto);
		Endereco enderecoSaved = enderecoService.save(endereco);
		EnderecoDTO responseDto = enderecoMapper.map(enderecoSaved);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
	
	@GetMapping
    public ResponseEntity<List<EnderecoDTO>> getAll() {
        List<EnderecoDTO> result = enderecoService.getAll().stream().map(enderecoMapper::map).collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<EnderecoDTO> findById(@PathVariable UUID id) {
        if (!enderecoService.exists(id)) {
            return ResponseEntity.notFound().build();
        }
        EnderecoDTO dto = enderecoMapper.map(enderecoService.findById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
