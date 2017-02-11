/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gamehub.models;

/**
 *
 * @author ahmed
 */
public class CathegorieSpecifique {
    private int id_cathegorie_specifique;
    private String nom;

    public CathegorieSpecifique(int id_cathegorie_specifique, String nom) {
        this.id_cathegorie_specifique = id_cathegorie_specifique;
        this.nom = nom;
    }

    public CathegorieSpecifique() {
    }

    public CathegorieSpecifique(String nom) {
        this.nom = nom;
    }

    public int getId_cathegorie_specifique() {
        return id_cathegorie_specifique;
    }

    public void setId_cathegorie_specifique(int id_cathegorie_specifique) {
        this.id_cathegorie_specifique = id_cathegorie_specifique;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return nom;
    }
    
    
}
