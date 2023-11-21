package io.farma.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import io.farma.dto.MedicamentoCreateDTO;
import io.farma.dto.MedicamentoDTO;
import io.farma.entity.Medicamento;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MedicamentoMapper {
	private ModelMapper modelMapper;

	public Medicamento map(MedicamentoCreateDTO dto) {
		Medicamento medicamento = modelMapper.map(dto, Medicamento.class);
		return medicamento;
	}

	public MedicamentoDTO map(Medicamento medicamento) {
		MedicamentoDTO dto = modelMapper.map(medicamento, MedicamentoDTO.class);
		return dto;
	}
}
