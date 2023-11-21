package io.farma.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import io.farma.dto.DataDTO;
import io.farma.entity.Data;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataMapper {
	private ModelMapper modelMapper;

	public DataDTO map(Data data) {
		DataDTO dto = modelMapper.map(data, DataDTO.class);
		return dto;
	}
}
