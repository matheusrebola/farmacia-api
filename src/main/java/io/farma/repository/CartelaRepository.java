package io.farma.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.farma.entity.Cartela;

@Repository
public interface CartelaRepository extends JpaRepository<Cartela, UUID>{

}
