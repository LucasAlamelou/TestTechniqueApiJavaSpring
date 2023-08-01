package com.testTechniqueJava.testTechnique.service;

import com.testTechniqueJava.testTechnique.models.Categorie;
import com.testTechniqueJava.testTechnique.models.Materiel;
import com.testTechniqueJava.testTechnique.repository.MaterielRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
@Service
@AllArgsConstructor
public class MaterielServiceImpl implements MaterielService{
    private final MaterielRepository materielRepository;
    @Override
    public Materiel create(Materiel materiel) {
        Categorie categorie = new Categorie();
        categorie.setIdCategorie(materiel.getCategorie().getIdCategorie());
        materiel.setCategorie(categorie);

        materiel.setUpdatedAt(Timestamp.from(Instant.now()));
        return materielRepository.save(materiel);
    }

    @Override
    public List<Materiel> listMateriel() {
        return materielRepository.findAll();
    }

    @Override
    public Materiel modify(Integer id, Materiel materiel) {
        return materielRepository.findById(id.longValue()).map(m -> {
            m.setNom(materiel.getNom());
            if(materiel.getCategorie() != null){
                Categorie categorie = new Categorie();
                categorie.setIdCategorie(materiel.getCategorie().getIdCategorie());
                m.setCategorie(categorie);
            }
            m.setMarque(materiel.getMarque());
            m.setDescription(materiel.getDescription());

            m.setTaille(materiel.getTaille());
            m.setDureeLocation(materiel.getDureeLocation());
            m.setCoutLocation(materiel.getCoutLocation());
            m.setCoutRemplacement(materiel.getCoutRemplacement());
            m.setImageUrl(materiel.getImageUrl());
            m.setUpdatedAt(Timestamp.from(Instant.now()));
            return materielRepository.save(m);
        }).orElseThrow(() -> new RuntimeException("Materiel not-found"));
    }

    @Override
    public String delete(Integer id) {
        materielRepository.deleteById(id.longValue());
        return "Materiel id : "+ id + " supprimé" ;
    }
}
