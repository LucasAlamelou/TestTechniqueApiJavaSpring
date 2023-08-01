package com.testTechniqueJava.testTechnique.dto;

public class MaterielInventaireDTO {

    private String nom;
    private Long total;

    public MaterielInventaireDTO(String nom, Long total){
        this.nom = nom;
        this.total = total;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }


}
