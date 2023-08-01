package com.testTechniqueJava.testTechnique.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

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

    @ManyToOne
    @JoinColumn(name = "directeur_personel_id", referencedColumnName ="employe_id", columnDefinition = "integer")
    private Employe directeurPersonnel;

}
