package com.uqam.mgl7010.application_web.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String email;
    private String mdp;

    private LocalDate dateAdhesion;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organisation_id")
    @JsonIgnore
    private Organisation organisation;



}
