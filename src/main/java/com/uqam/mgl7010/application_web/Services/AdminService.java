package com.uqam.mgl7010.application_web.Services;

import com.uqam.mgl7010.application_web.Entities.Admin;
import com.uqam.mgl7010.application_web.Repositories.AdminRepository;
import com.uqam.mgl7010.application_web.Repositories.OrganisationRepository;
import com.uqam.mgl7010.application_web.Repositories.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AdminService extends UtilisateurService{

    private final AdminRepository adminRepository;


    public AdminService(UtilisateurRepository utilisateurRepository, AdminRepository adminRepository, OrganisationRepository organisationRepository) {
        super(utilisateurRepository, organisationRepository);
        this.adminRepository = adminRepository;
    }

    public Admin createAdmin(String nom, String prenom, String email, String mdp) {
        if (checkUtilisateur(email,mdp) == null) {
            Admin admin = new Admin();
            admin.setNom(nom);
            admin.setPrenom(prenom);
            admin.setEmail(email);
            admin.setMdp(mdp);
            admin.setDateAdhesion(LocalDate.now());

            // Enregistrement dans la base de données
            return adminRepository.save(admin);

        }else {
            return null;
        }
    }


}
