package com.antoine.restservice.RestApp.controller;


import com.antoine.restservice.RestApp.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    //Produit/{id}
    @GetMapping(value = "Produits/{id}")
    public Product afficherUnProduit(@PathVariable int id){

        Product product = new Product(id, "Dildo", 5);
        return product;
    }

    @GetMapping(value="/Produits")
    public String listeProduits() {
        return "Un exemple de produit";
    }
}
