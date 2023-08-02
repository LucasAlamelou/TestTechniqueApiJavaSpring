package com.testTechniqueJava.testTechnique.controller;

import com.testTechniqueJava.testTechnique.models.Materiel;
import com.testTechniqueJava.testTechnique.service.MaterielService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materiel")
@AllArgsConstructor
public class MaterielController {
    private final MaterielService materielService;
    @PostMapping("/create-materiel")
    public Materiel create(@RequestBody Materiel materiel){
        return materielService.create(materiel);
    }
    @DeleteMapping("/delete-materiel-by-id")
    public String delete(@RequestBody Materiel materiel){
        return materielService.delete(materiel.getIdMateriel());
    }
    @PutMapping("/modify-materiel-by-id")
    public Materiel modify(@RequestBody Materiel materiel){
        return materielService.modify(materiel.getIdMateriel(), materiel);
    }
    @GetMapping("/get-list-materiel")
    public List<Materiel> getList(){
        return materielService.listMateriel();
    }


}
