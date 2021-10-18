package com.antoine.restservice.RestApp.controller;


import com.antoine.restservice.RestApp.model.Personnage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PersonnageController {

    private static ArrayList<Personnage> personnages = new ArrayList<>();
    static {
        personnages.add(new Personnage(1, "Antoine", "Guerrier"));
        personnages.add(new Personnage(2, "Rodolphe", "Guerrier"));
        personnages.add(new Personnage(3, "Juliette", "Magicienne"));
    }

    @GetMapping(value = "/personnages")
    public ArrayList<Personnage> listePersonnages(){
        return personnages;
    }

    @GetMapping(value = "personnages/{id}")
    public Personnage afficherUnPersonnage(@PathVariable int id){
        return personnages.get(id-1);
    }
}
