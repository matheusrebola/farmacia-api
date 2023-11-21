package io.farma.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

import io.farma.entity.Data;
import io.farma.repository.DataRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DataService {
	private DataRepository dataRepository;

	public List<Data> getAll() {
		return dataRepository.findAll();
	}

	public boolean exists(UUID id) {
		return dataRepository.existsById(id);
	}

	public Data findById(UUID id) {
		return dataRepository.findById(id).orElse(null);
	}

	public Data save(Data data) {
		return dataRepository.save(data);
	}
}
