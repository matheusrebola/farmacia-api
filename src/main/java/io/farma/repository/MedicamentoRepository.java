package io.farma.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.farma.entity.Medicamento;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, UUID>{

}
