package com.uqam.mgl7010.application_web.Services;

import com.uqam.mgl7010.application_web.Entities.*;
import com.uqam.mgl7010.application_web.Repositories.OrganisationRepository;
import com.uqam.mgl7010.application_web.Repositories.OutilRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OutilService
{

    private final OutilRepository outilRepository;

    private final OrganisationRepository organisationRepository;


    public OutilService(OutilRepository outilRepository, OrganisationRepository organisationRepository) {
        this.outilRepository = outilRepository;
        this.organisationRepository = organisationRepository;
    }


    public OutilElectrique createOutilE(long id,String nom , LocalDate dateAchat,int q)
    {

            OutilElectrique outilElectrique = new OutilElectrique();
            outilElectrique.setNom(nom);
            outilElectrique.setDateAchat(dateAchat);
            outilElectrique.setOrganisation(getOrganisationById(id));
            outilElectrique.setQuantite(q);

            return this.outilRepository.save(outilElectrique);


    }


    public OutilMecanique createOutilM(long id,String nom , LocalDate dateAchat,int q)
    {

            OutilMecanique outilMecanique= new OutilMecanique();
            outilMecanique.setNom(nom);
            outilMecanique.setDateAchat(dateAchat);
            outilMecanique.setOrganisation(getOrganisationById(id));
            outilMecanique.setQuantite(q);

            return this.outilRepository.save(outilMecanique);

    }


    public Organisation getOrganisationById(long id) {
        return organisationRepository.findById(id).orElseThrow();
    }


    public Organisation addOutilOrganisation(long organisation_id,Outil outil){
        Organisation organisation = organisationRepository.findById(organisation_id).orElseThrow();
        organisation.setOneOutil(outil);
        return organisationRepository.save(organisation);
    }




}
