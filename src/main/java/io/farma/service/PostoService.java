package io.farma.service;

import org.springframework.stereotype.Service;

import io.farma.entity.Posto;
import io.farma.repository.PostoRepository;

import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostoService {
	private PostoRepository postoRepository;

	public List<Posto> getAll() {
		return postoRepository.findAll();
	}

	public boolean exists(UUID id) {
		return postoRepository.existsById(id);
	}

	public Posto findById(UUID id) {
		return postoRepository.findById(id).orElse(null);
	}

	public Posto save(Posto posto) {
		return postoRepository.save(posto);
	}
}
