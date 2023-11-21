package io.farma.service;

import org.springframework.stereotype.Service;

import io.farma.entity.Duracao;
import io.farma.repository.DuracaoRepository;

import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DuracaoService {
	private DuracaoRepository duracaoRepository;

	public List<Duracao> getAll() {
		return duracaoRepository.findAll();
	}

	public boolean exists(UUID id) {
		return duracaoRepository.existsById(id);
	}

	public Duracao findById(UUID id) {
		return duracaoRepository.findById(id).orElse(null);
	}

	public Duracao save(Duracao duracao) {
		return duracaoRepository.save(duracao);
	}
}
