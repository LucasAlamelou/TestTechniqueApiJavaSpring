package com.testTechniqueJava.testTechnique.controller;

import com.testTechniqueJava.testTechnique.models.Categorie;
import com.testTechniqueJava.testTechnique.models.Employe;
import com.testTechniqueJava.testTechnique.models.Magasin;
import com.testTechniqueJava.testTechnique.service.CategorieService;
import com.testTechniqueJava.testTechnique.service.EmployeService;
import com.testTechniqueJava.testTechnique.service.MagasinService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/ajout")
public class CategorieEmployeMagasinController {
    private CategorieService categorieService;
    private EmployeService employeService;
    private MagasinService magasinService;

    @PostMapping("categorie")
    public Categorie create(@RequestBody Categorie categorie){
        if(categorie == null) return null;
        return categorieService.create(categorie);
    }

    @PostMapping("employe")
    public Employe create(@RequestBody Employe employe){
        return employeService.create(employe);
    }

    @PostMapping("magasin")
    public Magasin create(@RequestBody Magasin magasin){
        return magasinService.create(magasin);
    }

}
