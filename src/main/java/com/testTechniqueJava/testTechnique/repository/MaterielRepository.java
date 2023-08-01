package com.testTechniqueJava.testTechnique.repository;

import com.testTechniqueJava.testTechnique.models.Materiel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterielRepository extends JpaRepository<Materiel, Long> {
}
