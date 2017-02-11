/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gamehub.models;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mehdi
 */
public class Compte {

    private int id_compte;
    private String nom;
    private String prenom;
    private Date date_de_naissance;
    private String email;
    private String pseudo;
    private String mot_de_passe;
    private int etat;
    private int points;
    private int rank;
    private File image;
    private int nombre_signalisation;
    

    public Compte() {
    }

    public Compte(int id_compte) {
        this.id_compte = id_compte;
    }

    public int getId_compte() {
        return id_compte;
    }

    public void setId_compte(int id_compte) {
        this.id_compte = id_compte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDate_de_naissance() {
        return date_de_naissance;
    }

    public void setDate_de_naissance(Date date_de_naissance) {
        this.date_de_naissance = date_de_naissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public int getNombre_signalisation() {
        return nombre_signalisation;
    }

    public void setNombre_signalisation(int nombre_signalisation) {
        this.nombre_signalisation = nombre_signalisation;
    }

    public Compte(int id_compte, String nom, String prenom, Date date_de_naissance, String email, String pseudo, String mot_de_passe, int etat, int points, int rank, File image, int nombre_signalisation) {
        this.id_compte = id_compte;
        this.nom = nom;
        this.prenom = prenom;
        this.date_de_naissance = date_de_naissance;
        this.email = email;
        this.pseudo = pseudo;
        this.mot_de_passe = mot_de_passe;
        this.etat = etat;
        this.points = points;
        this.rank = rank;
        this.image = image;
        this.nombre_signalisation = nombre_signalisation;
    }
    
    public Compte(String nom, String prenom, Date date_de_naissance, String email, String pseudo, String mot_de_passe, int etat, int points, int rank, File image, int nombre_signalisation) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_de_naissance = date_de_naissance;
        this.email = email;
        this.pseudo = pseudo;
        this.mot_de_passe = mot_de_passe;
        this.etat = etat;
        this.points = points;
        this.rank = rank;
        this.image = image;
        this.nombre_signalisation = nombre_signalisation;
    }

    
    
    

}
