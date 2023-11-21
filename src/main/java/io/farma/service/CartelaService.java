package io.farma.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import io.farma.entity.Cartela;
import io.farma.repository.CartelaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartelaService {
	private CartelaRepository cartelaRepository;

	public List<Cartela> getAll() {
		return cartelaRepository.findAll();
	}

	public boolean exists(UUID id) {
		return cartelaRepository.existsById(id);
	}

	public Cartela findById(UUID id) {
		return cartelaRepository.findById(id).orElse(null);
	}

	public Cartela save(Cartela cartela) {
		return cartelaRepository.save(cartela);
	}
}
