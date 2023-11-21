package io.farma.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.farma.dto.PacienteCreateDTO;
import io.farma.dto.PacienteDTO;
import io.farma.entity.Paciente;
import io.farma.mapper.PacienteMapper;
import io.farma.service.PacienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {
	private PacienteService pacienteService;
    private PacienteMapper pacienteMapper;
	
	@PostMapping
    public ResponseEntity<PacienteDTO> create(@Valid @RequestBody PacienteCreateDTO requestDto) {
        Paciente cliente = pacienteMapper.map(requestDto);
        Paciente clienteSaved = pacienteService.save(cliente);
        PacienteDTO responseDto = pacienteMapper.map(clienteSaved);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
	
	@GetMapping
    public ResponseEntity<List<PacienteDTO>> getAll() {
        List<PacienteDTO> result = pacienteService.getAll().stream().map(pacienteMapper::map).collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<PacienteDTO> findById(@PathVariable UUID id) {
        if (!pacienteService.exists(id)) {
            return ResponseEntity.notFound().build();
        }
        PacienteDTO dto = pacienteMapper.map(pacienteService.findById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
