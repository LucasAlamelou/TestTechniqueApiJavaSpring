package com.testTechniqueJava.testTechnique.service;

import com.testTechniqueJava.testTechnique.models.Employe;
import java.util.List;

public interface EmployeService {
    Employe create(Employe categorie);

    List<Employe> getListEmploye();
}
