package io.farma.service;

import org.springframework.stereotype.Service;

import io.farma.entity.Endereco;
import io.farma.repository.EnderecoRepository;

import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnderecoService {
	private EnderecoRepository enderecoRepository;

	public List<Endereco> getAll() {
		return enderecoRepository.findAll();
	}

	public boolean exists(UUID id) {
		return enderecoRepository.existsById(id);
	}

	public Endereco findById(UUID id) {
		return enderecoRepository.findById(id).orElse(null);
	}

	public Endereco save(Endereco cliente) {
		return enderecoRepository.save(cliente);
	}
}
