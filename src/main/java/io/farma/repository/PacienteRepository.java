package io.farma.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.farma.entity.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, UUID>{

}
