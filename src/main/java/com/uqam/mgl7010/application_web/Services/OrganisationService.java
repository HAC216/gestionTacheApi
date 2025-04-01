package com.uqam.mgl7010.application_web.Services;

import com.uqam.mgl7010.application_web.Entities.Admin;
import com.uqam.mgl7010.application_web.Entities.Organisation;
import com.uqam.mgl7010.application_web.Repositories.AdminRepository;
import com.uqam.mgl7010.application_web.Repositories.OrganisationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganisationService {

    private final OrganisationRepository organisationRepository;

    private final AdminRepository adminRepository;
    public OrganisationService(OrganisationRepository organisationRepository, AdminRepository adminRepository) {
        this.organisationRepository = organisationRepository;
        this.adminRepository = adminRepository;
    }


    public List<Organisation> getAllOrganisation(){
        return organisationRepository.findAll();
    }

    public Optional<Organisation> getOrganisationById(long id){
        return organisationRepository.findById(id);
    }

    public Organisation createOrganisation(String nom , String type){
        Organisation organisation = new Organisation();
        organisation.setNom(nom);
        organisation.setType(type);

        return organisationRepository.save(organisation);
    }

    public Admin getAdmin(long admin_id){
        return this.adminRepository.findById(admin_id).orElseThrow();
    }

    public Admin addAdmin(long admin_id, long organisation_id){

        Admin admin = getAdmin(admin_id);
        Organisation organisation = this.organisationRepository.findById(organisation_id).orElseThrow();

        if (admin != null && organisation != null){

            organisation.addAdmin(admin);
            admin.setOrganisation(organisation);

            this.organisationRepository.save(organisation);
            return this.adminRepository.save(admin);
        }
        return null;
    }


}
