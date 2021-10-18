package com.antoine.restservice.RestApp.controller;


import com.antoine.restservice.RestApp.dao.PersonnageDao;
import com.antoine.restservice.RestApp.model.Personnage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonnageController {

    @Autowired
    private PersonnageDao personnageDao;

    @Operation(summary = "Retourne la  liste des personnages")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des personnages trouvée",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Personnage.class)) })})
    @GetMapping(value = "/personnages")
    public List<Personnage> listeDesPersonnages(){
        return personnageDao.findAll();
    }

    @Operation(summary = "Retourne un personnage")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Personnage trouvé",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Personnage.class)) })})
    @GetMapping(value = "personnages/{id}")
    public Personnage afficherUnPersonnage(@PathVariable int id){
        return personnageDao.findById(id);
    }

    @Operation(summary = "Ajoute un personnage")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Personnage ajouté",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Personnage.class)) })})
    @PostMapping(value = "/personnages")
    public void ajouterUnPersonnage(@RequestBody Personnage personnage) {
        personnageDao.save(personnage);
    }

    @Operation(summary = "Modifie un personnage")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Personnage modifié",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Personnage.class)) })})
    @PutMapping(value = "/personnages/{id}")
    public void modifierUnPersonnage(@PathVariable int id, @RequestBody Personnage perso) {
        for (Personnage personnage : personnageDao.findAll()) {
            if(personnage.getId() == id){
                personnage.setName(perso.getName());
                personnage.setType(perso.getType());
            }
        }
    }

    @Operation(summary = "Supprime un personnage")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Personnage supprimé",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Personnage.class)) })})
    @DeleteMapping(value = "/personnages/{id}")
    public void supprimerUnPersonnage(@PathVariable int id) {
        personnageDao.delete(id);
    }
}
