package com.testTechniqueJava.testTechnique.repository;

import com.testTechniqueJava.testTechnique.models.Inventaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventaireRepository extends JpaRepository<Inventaire, Long> {
}
