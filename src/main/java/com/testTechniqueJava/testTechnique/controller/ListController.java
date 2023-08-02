package com.testTechniqueJava.testTechnique.controller;

import com.testTechniqueJava.testTechnique.models.Employe;
import com.testTechniqueJava.testTechnique.models.Magasin;
import com.testTechniqueJava.testTechnique.service.EmployeService;
import com.testTechniqueJava.testTechnique.service.MagasinService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ListController {
    private EmployeService employeService;
    private MagasinService magasinService;

    @GetMapping("get-list-magasin")
    public List<Magasin> getListMagasin(){
        return magasinService.getListMagasin();
    }

    @GetMapping("get-list-employe")
    public List<Employe> getListEmploye(){
        return employeService.getListEmploye();
    }
}
