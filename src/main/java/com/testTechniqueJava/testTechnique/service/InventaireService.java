package com.testTechniqueJava.testTechnique.service;

import com.testTechniqueJava.testTechnique.dto.MaterielInventaireDTO;
import com.testTechniqueJava.testTechnique.models.Inventaire;

import java.util.List;

public interface InventaireService {
    Inventaire create(Inventaire inventaire);
    List<Inventaire> listMateriel();
    Inventaire modify(Integer id, Inventaire inventaire);
    String delete(Long id);

    List<MaterielInventaireDTO> countInventaire();
}
