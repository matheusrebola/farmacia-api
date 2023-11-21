package io.farma.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.farma.dto.CartelaCreateDTO;
import io.farma.dto.CartelaDTO;
import io.farma.entity.Cartela;
import io.farma.mapper.CartelaMapper;
import io.farma.service.CartelaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cartelas")
@RequiredArgsConstructor
public class CartelaController {
    private CartelaService cartelaService;
    private CartelaMapper cartelaMapper;
	
	@PostMapping
    public ResponseEntity<CartelaDTO> create(@Valid @RequestBody CartelaCreateDTO requestDto) {
		Cartela cartela = cartelaMapper.map(requestDto);
		Cartela cartelaSaved = cartelaService.save(cartela);
		CartelaDTO responseDto = cartelaMapper.map(cartelaSaved);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
	
	@GetMapping
    public ResponseEntity<List<CartelaDTO>> getAll() {
        List<CartelaDTO> result = cartelaService.getAll().stream().map(cartelaMapper::map).collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CartelaDTO> findById(@PathVariable UUID id) {
        if (!cartelaService.exists(id)) {
            return ResponseEntity.notFound().build();
        }
        CartelaDTO dto = cartelaMapper.map(cartelaService.findById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
