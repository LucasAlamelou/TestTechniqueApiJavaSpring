package com.testTechniqueJava.testTechnique.service;

import com.testTechniqueJava.testTechnique.dto.MaterielInventaireDTO;
import com.testTechniqueJava.testTechnique.models.Inventaire;
import com.testTechniqueJava.testTechnique.models.Magasin;
import com.testTechniqueJava.testTechnique.models.Materiel;
import com.testTechniqueJava.testTechnique.repository.InventaireRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
@AllArgsConstructor
public class InventaireServiceImpl implements InventaireService{
    private final InventaireRepository inventaireRepository;
    private final EntityManager entityManager;
    @Override
    public Inventaire create(Inventaire inventaire) {
        Magasin magasin = new Magasin();
        magasin.setIdMagasin(inventaire.getMagasin().getIdMagasin());
        inventaire.setMagasin(magasin);

        Materiel materiel = new Materiel();
        materiel.setIdMateriel(inventaire.getMateriel().getIdMateriel());
        inventaire.setMateriel(materiel);

        inventaire.setUpdatedAt(Timestamp.from(Instant.now()));
        return inventaireRepository.save(inventaire);
    }

    @Override
    public List<Inventaire> listMateriel() {
        return inventaireRepository.findAll();
    }

    @Override
    public Inventaire modify(Integer id, Inventaire inventaire) {
        return inventaireRepository.findById(id.longValue()).map(i -> {
           Magasin magasin = new Magasin();
           magasin.setIdMagasin(inventaire.getMagasin().getIdMagasin());

           Materiel materiel = new Materiel();
           materiel.setIdMateriel(inventaire.getMateriel().getIdMateriel());

           i.setUpdatedAt(Timestamp.from(Instant.now()));
            return inventaireRepository.save(i);
        }).orElseThrow(() -> new RuntimeException("Interventaire not-found"));
    }

    @Override
    public String delete(Long id) {
        inventaireRepository.deleteById(id);
        return "Materiel id : "+ id + " supprimé" ;
    }
    //@Query(value = "SELECT Materiel.nom, (SELECT COUNT(*) FROM Inventaire i WHERE i.materiel.idMateriel = m.idMateriel) AS total FROM Materiel m")
    public List<MaterielInventaireDTO> countInventaire(){

        //TypedQuery<Materiel> materielTypedQuery = entityManager.createQuery("from Materiel m where m.categorie.id = 1", Materiel.class);
        TypedQuery<MaterielInventaireDTO> inventaireDTOTypedQuery = entityManager.createQuery("SELECT new com.testTechniqueJava.testTechnique.dto.MaterielInventaireDTO(m.nom, (SELECT COUNT(*) FROM Inventaire i WHERE i.materiel.idMateriel = m.idMateriel)) FROM Materiel m", MaterielInventaireDTO.class);
        return inventaireDTOTypedQuery.getResultList();
    };
}
