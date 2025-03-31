package com.uqam.mgl7010.application_web.Entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Membre extends Utilisateur{

    private int score;


    @OneToMany(mappedBy = "membre", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tache> lisTache = new ArrayList<>();


    public boolean setOneTache(Tache tache){
        return this.lisTache.add(tache);
    }
}
