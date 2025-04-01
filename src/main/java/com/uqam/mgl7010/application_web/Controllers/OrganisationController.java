package com.uqam.mgl7010.application_web.Controllers;

import com.uqam.mgl7010.application_web.Entities.Admin;
import com.uqam.mgl7010.application_web.Entities.Organisation;
import com.uqam.mgl7010.application_web.Services.OrganisationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/organisation")
public class OrganisationController {

    private final OrganisationService organisationService;

    public OrganisationController(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }


    @PostMapping("/createOrganisation")
    public Organisation createOrganisation(@RequestBody Organisation request){
        return organisationService.createOrganisation(request.getNom(), request.getType());
    }

    @GetMapping("/list")
    public List<Organisation> getAllOrganisation(){
        return organisationService.getAllOrganisation();
    }


    @GetMapping("/OneOrganisation/{id}")
    public Optional<Organisation> getOrganisationById(@PathVariable long id) {
        return organisationService.getOrganisationById(id);
    }

    @PostMapping("/addAdmin/{id}/{id_organisation}")
    public Admin addAdmin(@PathVariable long id, @PathVariable long id_organisation){
        return organisationService.addAdmin(id,id_organisation);
    }



}
