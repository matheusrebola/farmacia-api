package io.farma.service;

import org.springframework.stereotype.Service;

import io.farma.entity.Medicamento;
import io.farma.repository.MedicamentoRepository;

import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicamentoService {
	private MedicamentoRepository medicamentoRepository;

	public List<Medicamento> getAll() {
		return medicamentoRepository.findAll();
	}

	public boolean exists(UUID id) {
		return medicamentoRepository.existsById(id);
	}

	public Medicamento findById(UUID id) {
		return medicamentoRepository.findById(id).orElse(null);
	}

	public Medicamento save(Medicamento medicamento) {
		return medicamentoRepository.save(medicamento);
	}
}
