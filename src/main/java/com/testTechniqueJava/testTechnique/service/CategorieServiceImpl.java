package com.testTechniqueJava.testTechnique.service;

import com.testTechniqueJava.testTechnique.models.Categorie;
import com.testTechniqueJava.testTechnique.repository.CategorieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
@AllArgsConstructor
public class CategorieServiceImpl implements CategorieService{
    private final CategorieRepository categorieRepository;
    @Override
    public Categorie create(Categorie categorie) {
        categorie.setUpdatedAt(Timestamp.from(Instant.now()));
        return categorieRepository.save(categorie);
    }
}
