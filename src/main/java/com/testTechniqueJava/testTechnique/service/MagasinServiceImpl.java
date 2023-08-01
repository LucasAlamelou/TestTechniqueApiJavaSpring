package com.testTechniqueJava.testTechnique.service;

import com.testTechniqueJava.testTechnique.models.Employe;
import com.testTechniqueJava.testTechnique.models.Magasin;
import com.testTechniqueJava.testTechnique.repository.MagasinRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
@AllArgsConstructor
public class MagasinServiceImpl implements MagasinService{
    private final MagasinRepository magasinRepository;
    @Override
    public Magasin create(Magasin magasin) {
        if(magasin.getDirecteurPersonnel() != null){
            Employe employe = new Employe();
            employe.setIdEmploye(magasin.getDirecteurPersonnel().getIdEmploye());
            magasin.setDirecteurPersonnel(employe);
        }
        magasin.setUpdatedAt(Timestamp.from(Instant.now()));
        return magasinRepository.save(magasin);
    }
}
