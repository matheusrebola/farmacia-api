package io.farma.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import io.farma.dto.PostoCreateDTO;
import io.farma.dto.PostoDTO;
import io.farma.entity.Posto;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PostoMapper {
	private ModelMapper modelMapper;

	public Posto map(PostoCreateDTO dto) {
		Posto posto = modelMapper.map(dto, Posto.class);
		return posto;
	}

	public PostoDTO map(Posto posto) {
		PostoDTO dto = modelMapper.map(posto, PostoDTO.class);
		return dto;
	}
}
