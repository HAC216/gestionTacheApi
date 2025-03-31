package com.uqam.mgl7010.application_web.Services;

import com.uqam.mgl7010.application_web.Entities.*;
import com.uqam.mgl7010.application_web.Repositories.*;
import org.springframework.stereotype.Service;

@Service
public class MembreService extends UtilisateurService {

    private final MembreRepository membreRepository;

    private final EmployeRepository employeRepository;
    private final VolontaireRepository volontaireRepository;

    public final OrganisationRepository organisationRepository;

    public MembreService(UtilisateurRepository utilisateurRepository, MembreRepository membreRepository, EmployeRepository employeRepository, VolontaireRepository volontaireRepository, OrganisationRepository organisationRepository) {
        super(utilisateurRepository, organisationRepository);
        this.membreRepository = membreRepository;
        this.employeRepository = employeRepository;
        this.volontaireRepository = volontaireRepository;
        this.organisationRepository = organisationRepository;
    }



    public Organisation getOrganisationById(long id) {
        return organisationRepository.findById(id).orElseThrow();
    }


    public Organisation addMembreOrganisation(long organisation_id, Membre membre){

        Organisation organisation = organisationRepository.findById(organisation_id).orElseThrow();
        organisation.setOneMembre(membre);

        return organisationRepository.save(organisation);
    }




}
