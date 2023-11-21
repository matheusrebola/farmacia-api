package io.farma.service;

import org.springframework.stereotype.Service;

import io.farma.entity.Paciente;
import io.farma.repository.PacienteRepository;

import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PacienteService {
	private PacienteRepository pacienteRepository;

	public List<Paciente> getAll() {
		return pacienteRepository.findAll();
	}

	public boolean exists(UUID id) {
		return pacienteRepository.existsById(id);
	}

	public Paciente findById(UUID id) {
		return pacienteRepository.findById(id).orElse(null);
	}

	public Paciente save(Paciente paciente) {
		return pacienteRepository.save(paciente);
	}
}
