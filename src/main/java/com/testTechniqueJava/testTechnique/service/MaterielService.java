package com.testTechniqueJava.testTechnique.service;

import com.testTechniqueJava.testTechnique.models.Materiel;

import java.util.List;

public interface MaterielService {
    Materiel create(Materiel materiel);
    List<Materiel> listMateriel();
    Materiel modify(Integer id, Materiel materiel);
    String delete(Integer id);
}
