package com.uqam.mgl7010.application_web.Entities;

import jakarta.persistence.*;
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
public class Organisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String type;

    @OneToMany(mappedBy = "organisation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Outil> listOutils = new ArrayList<>();

    @OneToMany(mappedBy = "organisation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Utilisateur> listUtilisateurs = new ArrayList<>();

    @OneToMany(mappedBy = "organisation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tache> lisTacheOrganisation = new ArrayList<>();

    private int score;


    public boolean setOneMembre(Membre membre){
        return this.listUtilisateurs.add(membre);
    }

    public boolean checkAdmin(long admin_id){
        for(Utilisateur utilisateur:this.listUtilisateurs){
            if(utilisateur.getId() == admin_id && utilisateur.getClass() == Admin.class){
                return true;
            }
        }
        return false;
    }

    public boolean addAdmin(Admin admin){

        if (!checkAdmin(admin.getId())){
            return this.listUtilisateurs.add(admin);
        }

        return  false;
    }

    public boolean setOneTache(Tache tache){
        return this.lisTacheOrganisation.add(tache);
    }


    public boolean setOneOutil(Outil outil){return this.listOutils.add(outil);}
}


