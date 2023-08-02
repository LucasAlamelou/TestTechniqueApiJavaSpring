package com.testTechniqueJava.testTechnique.controller;

import com.testTechniqueJava.testTechnique.dto.MaterielInventaireDTO;
import com.testTechniqueJava.testTechnique.models.Inventaire;
import com.testTechniqueJava.testTechnique.service.InventaireService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventaire")
@AllArgsConstructor
public class InventaireController {
    private final InventaireService inventaireService;
    @PostMapping("/create-inventaire")
    public Inventaire create(@RequestBody Inventaire inventaire){
        return inventaireService.create(inventaire);
    }
    @DeleteMapping("/delete-inventaire-by-id")
    public String delete(@RequestBody Inventaire inventaire){
        return inventaireService.delete(inventaire.getIdInventaire());
    }
    @PutMapping("/modify-inventaire-by-id")
    public Inventaire modify(@RequestBody Inventaire inventaire){
        System.out.println(inventaire.getIdInventaire());
        return inventaireService.modify(inventaire.getIdInventaire(), inventaire);
    }
    @GetMapping("/get-list-inventaire")
    public List<Inventaire> getList(){
        return inventaireService.listMateriel();
    }
    @GetMapping("/list-inventaire")
    public List<MaterielInventaireDTO> getCountMateriel(){
        return inventaireService.countInventaire();
    }

}
