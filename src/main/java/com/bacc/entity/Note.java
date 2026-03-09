package com.bacc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "note")
@Getter
@Setter
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_candidat")
    private Candidat candidat;

    @ManyToOne
    @JoinColumn(name = "id_matiere")
    private Matiere matiere;

    @ManyToOne
    @JoinColumn(name = "id_correcteur")
    private Correcteur correcteur;

    private Double note;
}
