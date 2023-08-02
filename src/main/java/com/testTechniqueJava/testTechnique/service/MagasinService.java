package com.testTechniqueJava.testTechnique.service;

import com.testTechniqueJava.testTechnique.models.Magasin;

import java.util.List;

public interface MagasinService {
    Magasin create(Magasin magasin);
    List<Magasin> getListMagasin();
}
