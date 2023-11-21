package io.farma.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import io.farma.dto.CartelaCreateDTO;
import io.farma.dto.CartelaDTO;
import io.farma.entity.Cartela;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CartelaMapper {
	private ModelMapper modelMapper;

	public Cartela map(CartelaCreateDTO dto) {
		Cartela cartela = modelMapper.map(dto, Cartela.class);
		return cartela;
	}

	public CartelaDTO map(Cartela cartela) {
		CartelaDTO dto = modelMapper.map(cartela, CartelaDTO.class);
		return dto;
	}
}
