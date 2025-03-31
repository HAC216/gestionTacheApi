package com.uqam.mgl7010.application_web.Services;

import com.uqam.mgl7010.application_web.Entities.Organisation;
import com.uqam.mgl7010.application_web.Entities.Utilisateur;
import com.uqam.mgl7010.application_web.Repositories.OrganisationRepository;
import com.uqam.mgl7010.application_web.Repositories.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    private final OrganisationRepository organisationRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository, OrganisationRepository organisationRepository) {
        this.utilisateurRepository = utilisateurRepository;
        this.organisationRepository = organisationRepository;
    }


    public Utilisateur checkUtilisateur(String email, String mdp){
        List<Utilisateur> utilisateurList = utilisateurRepository.findAll();
        for(Utilisateur utilisateur:utilisateurList){
            if (utilisateur.getEmail().equalsIgnoreCase(email) && utilisateur.getMdp().equalsIgnoreCase(mdp)){
                return utilisateur;
            }
        }
        return null;
    }

    public List<Utilisateur> getAllUsers(){
        return utilisateurRepository.findAll();
    }


    public Utilisateur getUtilisateur(long id){

        return utilisateurRepository.findById(id).orElseThrow();
    }


    public boolean checkOrganisationUtilisateur(long id , long organisation_id){
        Utilisateur utilisateur = utilisateurRepository.findById(id).orElseThrow();

        if (utilisateur != null){
            if(utilisateur.getOrganisation() != null){

                if (organisation_id == utilisateur.getOrganisation().getId()){
                    return true;
                }

            }
        }

        return false;

    }

    public Utilisateur login(String email,String mdp){
        List<Utilisateur> utilisateurList = utilisateurRepository.findAll();
        for(Utilisateur utilisateur:utilisateurList){
            if (utilisateur.getEmail().equalsIgnoreCase(email) && utilisateur.getMdp().equalsIgnoreCase(mdp)){
                return utilisateur;
            }
        }
        return null;
    }

    public  Organisation getOrganisation(String email,String mdp){
        List<Organisation> organisationList = this.organisationRepository.findAll();
        for(Organisation organisation:organisationList){
            for(Utilisateur utilisateur:organisation.getListUtilisateurs()){
                if (utilisateur.getEmail().equalsIgnoreCase(email) && utilisateur.getMdp().equalsIgnoreCase(mdp)){
                    return organisation;
                }
            }

        }
        return null;
    }
}

