package com.uqam.mgl7010.application_web.Services;

import com.uqam.mgl7010.application_web.Entities.Employe;
import com.uqam.mgl7010.application_web.Entities.Organisation;
import com.uqam.mgl7010.application_web.Repositories.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmployeService extends MembreService{

    private final EmployeRepository employeRepository;

    public EmployeService(UtilisateurRepository utilisateurRepository, MembreRepository membreRepository, EmployeRepository employeRepository, VolontaireRepository volontaireRepository, OrganisationRepository organisationRepository, EmployeRepository employeRepository1) {
        super(utilisateurRepository, membreRepository, employeRepository, volontaireRepository, organisationRepository);
        this.employeRepository = employeRepository1;
    }

    public Employe createEmploye(String nom, String prenom, String email, String mdp,long organisation_id) {

        Organisation organisation = getOrganisationById(organisation_id);

        if (checkUtilisateur(email, mdp) == null && organisation != null) {

            Employe e = new Employe();

            e.setNom(nom);
            e.setPrenom(prenom);
            e.setEmail(email);
            e.setMdp(mdp);
            e.setDateAdhesion(LocalDate.now());
            e.setOrganisation(organisation);


            // Enregistrement dans la base de données
            return employeRepository.save(e);

        }

        return null;

    }
}

