package com.antoine.restservice.RestApp.dao;

import com.antoine.restservice.RestApp.model.Personnage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnageDao extends JpaRepository<Personnage, Integer> {

}
