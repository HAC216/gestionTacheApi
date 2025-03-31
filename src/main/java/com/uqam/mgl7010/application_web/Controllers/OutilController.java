package com.uqam.mgl7010.application_web.Controllers;


import com.uqam.mgl7010.application_web.Entities.Outil;
import com.uqam.mgl7010.application_web.Entities.OutilElectrique;
import com.uqam.mgl7010.application_web.Entities.OutilMecanique;
import com.uqam.mgl7010.application_web.Entities.Tache;
import com.uqam.mgl7010.application_web.Services.OutilService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/outil")
public class OutilController {


    private final OutilService outilService;

    public OutilController(OutilService outilService) {
        this.outilService = outilService;
    }


    @PostMapping("/addOutilE/{id_organisation}")
    public OutilElectrique addOutilE(@RequestBody Outil outil, @PathVariable long id_organisation) {
        return outilService.createOutilE(id_organisation, outil.getNom(), outil.getDateAchat(),outil.getQuantite());
    }



    @PostMapping("/addOutilM/{id_organisation}")
    public OutilMecanique addOutilM(@RequestBody Outil outil, @PathVariable long id_organisation) {
        return outilService.createOutilM(id_organisation, outil.getNom(), outil.getDateAchat(), outil.getQuantite());
    }



}