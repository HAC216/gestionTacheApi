package com.uqam.mgl7010.application_web.Controllers;


import com.uqam.mgl7010.application_web.Entities.Employe;
import com.uqam.mgl7010.application_web.Entities.Volontaire;
import com.uqam.mgl7010.application_web.Services.EmployeService;
import com.uqam.mgl7010.application_web.Services.MembreService;
import com.uqam.mgl7010.application_web.Services.VolontaireService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/membre")
public class MembreController
{

    private final EmployeService employeService;

    private final VolontaireService volontaireService;

    private final MembreService membreService;

    public MembreController(EmployeService employeService, VolontaireService volontaireService, MembreService membreService) {
        this.employeService = employeService;
        this.volontaireService = volontaireService;
        this.membreService = membreService;
    }



    @PostMapping("/createEmploye/{organisation_id}")
    public Employe createEmploye(@RequestBody Employe employe,@PathVariable int organisation_id) {
        return employeService.createEmploye(employe.getNom(), employe.getPrenom(), employe.getEmail(), employe.getMdp(),organisation_id);
    }

    @PostMapping("/createVolontaire/{organisation_id}")
    public Volontaire createVolontaire(@RequestBody Volontaire volontaire,@PathVariable long organisation_id) {
        return volontaireService.createVolontaire(volontaire.getNom(), volontaire.getPrenom(), volontaire.getEmail(), volontaire.getMdp(),organisation_id);
    }
}
