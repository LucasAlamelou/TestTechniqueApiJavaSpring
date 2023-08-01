package com.testTechniqueJava.testTechnique.repository;

import com.testTechniqueJava.testTechnique.models.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
}
