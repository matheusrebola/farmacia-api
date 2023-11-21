package io.farma.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.farma.dto.DosagemCreateDTO;
import io.farma.dto.DosagemDTO;
import io.farma.entity.Dosagem;
import io.farma.mapper.DosagemMapper;
import io.farma.service.DosagemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dosagens")
@RequiredArgsConstructor
public class DosagemController {
    private DosagemService dosagemService;
    private DosagemMapper dosagemMapper;
	
	@PostMapping
    public ResponseEntity<DosagemDTO> create(@Valid @RequestBody DosagemCreateDTO requestDto) {
		Dosagem dosagem = dosagemMapper.map(requestDto);
		Dosagem dosagemSaved = dosagemService.save(dosagem);
		DosagemDTO responseDto = dosagemMapper.map(dosagemSaved);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
	
	@GetMapping
    public ResponseEntity<List<DosagemDTO>> getAll() {
        List<DosagemDTO> result = dosagemService.getAll().stream().map(dosagemMapper::map).collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<DosagemDTO> findById(@PathVariable UUID id) {
        if (!dosagemService.exists(id)) {
            return ResponseEntity.notFound().build();
        }
        DosagemDTO dto = dosagemMapper.map(dosagemService.findById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
