package io.farma.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import io.farma.dto.EnderecoCreateDTO;
import io.farma.dto.EnderecoDTO;
import io.farma.entity.Endereco;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EnderecoMapper {
	private ModelMapper modelMapper;

	public Endereco map(EnderecoCreateDTO dto) {
		Endereco endereco = modelMapper.map(dto, Endereco.class);
		return endereco;
	}

	public EnderecoDTO map(Endereco endereco) {
		EnderecoDTO dto = modelMapper.map(endereco, EnderecoDTO.class);
		return dto;
	}
}
