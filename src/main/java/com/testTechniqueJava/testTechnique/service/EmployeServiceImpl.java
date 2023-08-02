package com.testTechniqueJava.testTechnique.service;

import com.testTechniqueJava.testTechnique.models.Employe;
import com.testTechniqueJava.testTechnique.models.Magasin;
import com.testTechniqueJava.testTechnique.repository.EmployeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeServiceImpl implements EmployeService{
    private final EmployeRepository employeRepository;
    @Override
    public Employe create(Employe employe) {
        if(employe.getMagasin() != null){
            Magasin magasin = new Magasin();
            magasin.setIdMagasin(employe.getMagasin().getIdMagasin());
            employe.setMagasin(magasin);
        }
        employe.setUpdatedAt(Timestamp.from(Instant.now()));
        return employeRepository.save(employe);
    }

    @Override
    public List<Employe> getListEmploye() {
        return employeRepository.findAll();
    }


}
