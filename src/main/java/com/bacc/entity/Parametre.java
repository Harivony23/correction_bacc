package com.bacc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "parametre")
@Getter
@Setter
public class Parametre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_matiere")
    private Matiere matiere;

    private Double diff;

    @ManyToOne
    @JoinColumn(name = "id_operateur")
    private Operateur operateur;

    @ManyToOne
    @JoinColumn(name = "id_resolution")
    private Resolution resolution;
}
