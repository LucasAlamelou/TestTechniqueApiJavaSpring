package com.testTechniqueJava.testTechnique.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "employe")
@Getter
@Setter
@NoArgsConstructor
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employe_id")
    private Integer idEmploye;
    @Column(length = 45, nullable = false)
    private String nom;
    @Column(length = 45, nullable = false)
    private String prenom;
    @Column(length = 2048)
    private String imageUrl;
    @Column(length = 50)
    private String email;
    @Column(length = 16, nullable = false)
    private String login;
    @Column(length = 40, nullable = false)
    private String mdp;
    @Column(nullable = false)
    private Boolean actif;
    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @ManyToOne
    @JoinColumn(name = "magasin_id",referencedColumnName = "magasin_id")
    private Magasin magasin;

}
