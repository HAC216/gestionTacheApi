package com.uqam.mgl7010.application_web.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private LocalDate dateExecution;
    private String commentaire;

    @OneToMany(mappedBy = "tache", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Outil> listOutils = new ArrayList<>();

    private EtatTache etat;
    private NiveauTache niveau;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "membre_id")
    @JsonIgnore
    private Membre membre;


    @JsonProperty("membre_id")
    public Long getMembreId() {
        return membre != null ? membre.getId() : null;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organisation_id")
    @JsonIgnore
    private Organisation organisation;

    @JsonProperty("organisation_id")
    public Long getOrganisationId() {
        return organisation != null ? organisation.getId() : null;
    }

    public Boolean setOneOutil(Outil outil) {
        return this.listOutils.add(outil);
    }
}