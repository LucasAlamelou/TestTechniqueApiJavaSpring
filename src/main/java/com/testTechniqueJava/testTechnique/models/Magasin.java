package com.testTechniqueJava.testTechnique.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "magasin")
@Getter
@Setter
@NoArgsConstructor
public class Magasin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "magasin_id")
    private Integer idMagasin;
    @Column(nullable = false)
    private String ville;
    @Column(name= "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @ManyToOne()
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "idEmploye"
    ) // gère la boucle infini de fetch entre table
    @JoinColumn(name = "directeur_personel_id", referencedColumnName ="employe_id", columnDefinition = "integer")
    private Employe directeurPersonnel;

    @OneToMany(mappedBy = "magasin")
    private List<Employe> employeList;
}
