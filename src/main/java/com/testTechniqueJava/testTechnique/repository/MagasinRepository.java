package com.testTechniqueJava.testTechnique.repository;

import com.testTechniqueJava.testTechnique.models.Magasin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagasinRepository extends JpaRepository<Magasin, Long> {
}
