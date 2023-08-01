package com.testTechniqueJava.testTechnique.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "inventaire")
@Getter
@Setter
@NoArgsConstructor
public class Inventaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventaire_id")
    private Integer idInventaire;
    @ManyToOne
    @JoinColumn(name = "materiel_id", columnDefinition = "integer", nullable = false, referencedColumnName = "materiel_id")
    private Materiel materiel;
    @ManyToOne
    @JoinColumn(name = "magasin_id", columnDefinition = "integer", nullable = false, referencedColumnName = "magasin_id")
    private Magasin magasin;
    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
}
