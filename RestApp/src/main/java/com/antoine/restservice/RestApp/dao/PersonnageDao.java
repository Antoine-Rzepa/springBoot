package com.antoine.restservice.RestApp.dao;

import com.antoine.restservice.RestApp.model.Personnage;

import java.util.List;

public interface PersonnageDao {

    public List<Personnage> findAll();
    public  Personnage findById(int id);
    public void save(Personnage personnage);
    public void delete(int id);

}
