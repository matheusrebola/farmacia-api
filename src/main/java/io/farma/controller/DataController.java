package io.farma.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import io.farma.dto.DataDTO;
import io.farma.mapper.DataMapper;
import io.farma.service.DataService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/datas")
@RequiredArgsConstructor
public class DataController {
    private DataService dataService;
    private DataMapper dataMapper;
	
    @GetMapping
    public ResponseEntity<List<DataDTO>> getAll() {
        List<DataDTO> result = dataService.getAll().stream().map(dataMapper::map).collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<DataDTO> findById(@PathVariable UUID id) {
        if (!dataService.exists(id)) {
            return ResponseEntity.notFound().build();
        }
        DataDTO dto = dataMapper.map(dataService.findById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
