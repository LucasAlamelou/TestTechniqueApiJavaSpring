package com.testTechniqueJava.testTechnique.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "materiel")
@Getter
@Setter
@NoArgsConstructor
public class Materiel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "materiel_id")
    private Integer idMateriel;
    @Column(nullable = false)
    private String nom;
    @Column(name = "description", columnDefinition = "text")
    private String description;
    @Column(length = 45, nullable = false)
    private String marque;
    @Column(name = "image_url" ,length = 2048)
    private String imageUrl;
    @Enumerated(EnumType.STRING)
    @Column(name = "taille")
    private Taille taille; //Usage .setTaille(Taille.PETIT)
    @Column(name = "duree_location", nullable = false)
    private Integer dureeLocation;
    @Column(name = "cout_location", nullable = false, columnDefinition = "decimal")
    private Float coutLocation;
    @Column(name = "cout_remplacement", nullable = false, columnDefinition = "decimal")
    private Float coutRemplacement;
    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @ManyToOne
    @JoinColumn(name="categorie_id", nullable = false, referencedColumnName="categorie_id",  columnDefinition= "integer")
    private Categorie categorie;

    @OneToMany(targetEntity = Inventaire.class, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private List<Inventaire> inventaires = new ArrayList<>();
}
