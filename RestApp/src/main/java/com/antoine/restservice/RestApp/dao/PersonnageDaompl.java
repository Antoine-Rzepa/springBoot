package com.antoine.restservice.RestApp.dao;

import com.antoine.restservice.RestApp.model.Personnage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class PersonnageDaompl implements PersonnageDao{

    private static List<Personnage> personnages = new ArrayList<>();
    static {
        personnages.add(new Personnage(1, "Antoine", "Guerrier"));
        personnages.add(new Personnage(2, "Rodolphe", "Guerrier"));
        personnages.add(new Personnage(3, "Juliette", "Magicienne"));
    }

    @Override
    public List<Personnage> findAll() {
        return personnages;
    }

    @Override
    public Personnage findById(int id) {
        for (Personnage personnage : personnages) {
            if(personnage.getId() == id){
                return personnage;
            }
        }
        return null;
    }

    @Override
    public void save(Personnage personnage) {
        personnages.add(personnage);
    }

    @Override
    public void delete(int id) {
        for (Personnage personnage : personnages) {
            if(personnage.getId() == id){
                personnages.remove(personnage);
            }
        }
    }
}
