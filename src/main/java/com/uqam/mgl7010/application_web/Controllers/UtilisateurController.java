package com.uqam.mgl7010.application_web.Controllers;

import com.uqam.mgl7010.application_web.Entities.Admin;
import com.uqam.mgl7010.application_web.Entities.Organisation;
import com.uqam.mgl7010.application_web.Entities.Utilisateur;
import com.uqam.mgl7010.application_web.Services.UtilisateurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/utilisateur")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/list")
    public List<Utilisateur> getAllUsers(){
        return utilisateurService.getAllUsers();
    }


    @GetMapping("/utilisateur/{id}")
    public Utilisateur getUser(@PathVariable long id){
        return utilisateurService.getUtilisateur(id);
    }


    @GetMapping("/checkutilisateur/{id}/{id_organisation}")
    public boolean checkUser(@PathVariable long id,@PathVariable long id_organisation){
        return utilisateurService.checkOrganisationUtilisateur(id,id_organisation);
    }

    @GetMapping("/login")
    public Utilisateur login(@RequestParam String email,@RequestParam String mdp){
        return utilisateurService.login(email,mdp);
    }

    @GetMapping("/Organisation")
    public Organisation getUserOrganisation(@RequestParam String email, @RequestParam String mdp){
        return utilisateurService.getOrganisation(email,mdp);
    }
}
