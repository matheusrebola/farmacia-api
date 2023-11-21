package io.farma.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.farma.dto.MedicamentoCreateDTO;
import io.farma.dto.MedicamentoDTO;
import io.farma.entity.Medicamento;
import io.farma.mapper.MedicamentoMapper;
import io.farma.service.MedicamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medicamentos")
@RequiredArgsConstructor
public class MedicamentoController {
    private MedicamentoService medicamentoService;
    private MedicamentoMapper medicamentoMapper;
	
	@PostMapping
    public ResponseEntity<MedicamentoDTO> create(@Valid @RequestBody MedicamentoCreateDTO requestDto) {
		Medicamento medicamento = medicamentoMapper.map(requestDto);
		Medicamento medicamentoSaved = medicamentoService.save(medicamento);
		MedicamentoDTO responseDto = medicamentoMapper.map(medicamentoSaved);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
	
	@GetMapping
    public ResponseEntity<List<MedicamentoDTO>> getAll() {
        List<MedicamentoDTO> result = medicamentoService.getAll().stream().map(medicamentoMapper::map).collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<MedicamentoDTO> findById(@PathVariable UUID id) {
        if (!medicamentoService.exists(id)) {
            return ResponseEntity.notFound().build();
        }
        MedicamentoDTO dto = medicamentoMapper.map(medicamentoService.findById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
