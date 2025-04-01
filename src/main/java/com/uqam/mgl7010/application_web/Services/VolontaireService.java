package com.uqam.mgl7010.application_web.Services;

import com.uqam.mgl7010.application_web.Entities.Organisation;
import com.uqam.mgl7010.application_web.Entities.Volontaire;
import com.uqam.mgl7010.application_web.Repositories.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class VolontaireService extends MembreService {

    private final VolontaireRepository volontaireRepository;
    public VolontaireService(UtilisateurRepository utilisateurRepository, MembreRepository membreRepository, EmployeRepository employeRepository, VolontaireRepository volontaireRepository, OrganisationRepository organisationRepository, VolontaireRepository volontaireRepository1) {
        super(utilisateurRepository, membreRepository, employeRepository, volontaireRepository, organisationRepository);
        this.volontaireRepository = volontaireRepository1;
    }

    public Volontaire createVolontaire(String nom, String prenom, String email, String mdp , long organisation_id) {

        Organisation organisation = getOrganisationById(organisation_id);

        if (checkUtilisateur(email, mdp) == null && organisation != null) {


            Volontaire v = new Volontaire();
            v.setNom(nom);
            v.setPrenom(prenom);
            v.setEmail(email);
            v.setMdp(mdp);
            v.setDateAdhesion(LocalDate.now());
            v.setOrganisation(organisation);

            // Enregistrement dans la base de données
            return volontaireRepository.save(v);

        }

        return null;

    }
}
