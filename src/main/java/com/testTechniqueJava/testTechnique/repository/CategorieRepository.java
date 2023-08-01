package com.testTechniqueJava.testTechnique.repository;

import com.testTechniqueJava.testTechnique.models.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}
