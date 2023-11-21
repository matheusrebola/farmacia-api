package io.farma.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import io.farma.dto.DosagemCreateDTO;
import io.farma.dto.DosagemDTO;
import io.farma.entity.Dosagem;
import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class DosagemMapper {
	private ModelMapper modelMapper;

	public Dosagem map(DosagemCreateDTO dto) {
		Dosagem dosagem = modelMapper.map(dto, Dosagem.class);
		return dosagem;
	}

	public DosagemDTO map(Dosagem dosagem) {
		DosagemDTO dto = modelMapper.map(dosagem, DosagemDTO.class);
		return dto;
	}
}
