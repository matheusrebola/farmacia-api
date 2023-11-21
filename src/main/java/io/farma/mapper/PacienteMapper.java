package io.farma.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import io.farma.dto.PacienteCreateDTO;
import io.farma.dto.PacienteDTO;
import io.farma.entity.Paciente;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PacienteMapper {
	private ModelMapper modelMapper;

	public Paciente map(PacienteCreateDTO dto) {
		Paciente paciente = modelMapper.map(dto, Paciente.class);
		return paciente;
	}

	public PacienteDTO map(Paciente paciente) {
		PacienteDTO dto = modelMapper.map(paciente, PacienteDTO.class);
		return dto;
	}
}
