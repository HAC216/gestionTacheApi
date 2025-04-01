package com.uqam.mgl7010.application_web.Controllers;

import com.uqam.mgl7010.application_web.Entities.Admin;
import com.uqam.mgl7010.application_web.Entities.Tache;
import com.uqam.mgl7010.application_web.Services.TacheService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/tache")
public class TacheController {

    private final TacheService tacheService;

    public TacheController(TacheService tacheService) {
        this.tacheService = tacheService;
    }


    @PostMapping("/addTache/{id_organisation}/{membre_id}")
    public Tache addTache(@RequestBody Tache tache, @PathVariable long id_organisation, @PathVariable long membre_id){
        return tacheService.createTache(id_organisation, membre_id,tache.getDescription(), tache.getNiveau());

    }

    @PostMapping("/addOutilTache/{id_tache}/{outil_id}")
    public Tache addOutilTache(@PathVariable long id_tache, @PathVariable long outil_id){
        return tacheService.addOutilTache(id_tache,outil_id);
    }


    @PostMapping("/addCommentaire/{id_tache}")
    public Tache addCommentaireTache(@PathVariable long id_tache,@RequestParam String commentaire){
        return tacheService.setCommentaireTache(id_tache,commentaire);
    }

    @PostMapping("/setEtat/{id_tache}")
    public Tache setEtatTache(@PathVariable long id_tache){
        return tacheService.setEtatTache(id_tache);
    }

}
