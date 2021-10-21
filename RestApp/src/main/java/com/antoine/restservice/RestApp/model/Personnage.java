package com.antoine.restservice.RestApp.model;

import javax.persistence.*;

@Entity
@Table(name = "personnages")
public class Personnage {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "nom")
    private String name;
    @Column
    private String type;

    public Personnage(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Personnage() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Personnage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
