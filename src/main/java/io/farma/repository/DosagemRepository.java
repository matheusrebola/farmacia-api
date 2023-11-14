package io.farma.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.farma.entity.Dosagem;

@Repository
public interface DosagemRepository extends JpaRepository<Dosagem, UUID>{

}
