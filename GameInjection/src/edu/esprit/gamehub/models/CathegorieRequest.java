/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gamehub.models;

import java.sql.Timestamp;

/**
 *
 * @author ahmed
 */
public class CathegorieRequest {
    
    private int id_request;
    private String nom;
    private Timestamp date;
    private int id_compte;

    public CathegorieRequest(int id_request, String nom, Timestamp date, int id_compte) {
        this.id_request = id_request;
        this.nom = nom;
        this.date = date;
        this.id_compte = id_compte;
    }

    public CathegorieRequest(String nom, Timestamp date, int id_compte) {
        this.nom = nom;
        this.date = date;
        this.id_compte = id_compte;
    }

    public CathegorieRequest(String nom, int id_compte) {
        this.nom = nom;
        this.id_compte = id_compte;
    }
    
    

    public int getId_request() {
        return id_request;
    }

    public void setId_request(int id_request) {
        this.id_request = id_request;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getId_compte() {
        return id_compte;
    }

    public void setId_compte(int id_compte) {
        this.id_compte = id_compte;
    }

    @Override
    public String toString() {
        return "CathegorieRequest{" + "id_request=" + id_request + ", nom=" + nom + ", date=" + date + ", id_compte=" + id_compte + '}';
    }
   

    
}
