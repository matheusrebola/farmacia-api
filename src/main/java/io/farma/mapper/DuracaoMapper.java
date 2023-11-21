package io.farma.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import io.farma.dto.DuracaoCreateDTO;
import io.farma.dto.DuracaoDTO;
import io.farma.entity.Duracao;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DuracaoMapper {
	private ModelMapper modelMapper;

	public Duracao map(DuracaoCreateDTO dto) {
		Duracao duracao = modelMapper.map(dto, Duracao.class);
		return duracao;
	}

	public DuracaoDTO map(Duracao duracao) {
		DuracaoDTO dto = modelMapper.map(duracao, DuracaoDTO.class);
		return dto;
	}
}
