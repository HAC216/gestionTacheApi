package com.uqam.mgl7010.application_web.Services;

import com.uqam.mgl7010.application_web.Entities.*;
import com.uqam.mgl7010.application_web.Repositories.MembreRepository;
import com.uqam.mgl7010.application_web.Repositories.OrganisationRepository;
import com.uqam.mgl7010.application_web.Repositories.OutilRepository;
import com.uqam.mgl7010.application_web.Repositories.TacheRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TacheService {

    public final TacheRepository tacheRepository;

    public final OrganisationRepository organisationRepository;

    public final MembreRepository membreRepository;

    public final OutilRepository outilRepository;

    public TacheService(TacheRepository tacheRepository, OrganisationRepository organisationRepository, MembreRepository membreRepository, OutilRepository outilRepository) {
        this.tacheRepository = tacheRepository;
        this.organisationRepository = organisationRepository;
        this.membreRepository = membreRepository;
        this.outilRepository = outilRepository;
    }


    public Tache createTache(long id,long membreid, String description, NiveauTache niveauTache){
        Tache tache = new Tache();
        Membre membre = getMembre(membreid);
        tache.setDescription(description);
        tache.setEtat(EtatTache.PLANNED);
        tache.setNiveau(niveauTache);
        Organisation organisation = getOrganisationById(id);
        organisation.setScore(organisation.getScore() + niveauTache.getValeur());
        tache.setOrganisation(organisation);
        tache.setMembre(membre);
        membre.setOneTache(tache);
        membre.setScore(membre.getScore() + niveauTache.getValeur());

        return this.tacheRepository.save(tache);
    }


    public Organisation getOrganisationById(long id) {
        return organisationRepository.findById(id).orElseThrow();
    }


    public Organisation addTacheOrganisation(long organisation_id, Tache tache){

        Organisation organisation = organisationRepository.findById(organisation_id).orElseThrow();
        organisation.setOneTache(tache);

        return organisationRepository.save(organisation);
    }

    public Membre getMembre(long id){
        return membreRepository.findById(id).orElseThrow();
    }


    public Tache addOutilTache(long idTache, long idOutil){
       Tache tache = getTache(idTache);
       tache.setEtat(EtatTache.IN_PROGRESS);
       Outil outil = getOutil(idOutil);
       outil.setQuantite(outil.getQuantite() -1);
       outil.setNombreUtilisateur(outil.getNombreUtilisateur() + 1);
       outil.setTache(tache);

       tache.setOneOutil(outil);
       return this.tacheRepository.save(tache);

    }


    public Tache getTache(long idTache){

        return this.tacheRepository.findById(idTache).orElseThrow();
    }
    public Outil getOutil(long idOutil){
        return outilRepository.findById(idOutil).orElseThrow();
    }


    public Tache setCommentaireTache(long idTache , String commentaire)
    {
        Tache tache = getTache(idTache);
        tache.setCommentaire(commentaire);
       return this.tacheRepository.save(tache);
    }

    public Tache setEtatTache(long idTache)
    {
        Tache tache = getTache(idTache);
        tache.setEtat(EtatTache.DONE);
        tache.setDateExecution(LocalDate.now());
        return this.tacheRepository.save(tache);
    }



}
