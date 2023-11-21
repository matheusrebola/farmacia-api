package io.farma.service;

import org.springframework.stereotype.Service;

import io.farma.entity.Dosagem;
import io.farma.repository.DosagemRepository;

import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DosagemService {
	private DosagemRepository dosagemRepository;

	public List<Dosagem> getAll() {
		return dosagemRepository.findAll();
	}

	public boolean exists(UUID id) {
		return dosagemRepository.existsById(id);
	}

	public Dosagem findById(UUID id) {
		return dosagemRepository.findById(id).orElse(null);
	}

	public Dosagem save(Dosagem dosagem) {
		return dosagemRepository.save(dosagem);
	}
}
