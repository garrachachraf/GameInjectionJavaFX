/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gamehub.models;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author ahmed
 */
public class Post {
    private int id_post;
    private String sujet;
    private String titre;
    private Timestamp date ;
    private int cathegorieS;

    public Post(int id_post, String sujet, String titre, Timestamp date, int cathegorie2) {
        this.id_post = id_post;
        this.sujet = sujet;
        this.titre = titre;
        this.date = date;
        this.cathegorieS = cathegorie2;
    }

    public Post(String sujet, String titre, int cathegorie2) {
        this.sujet = sujet;
        this.titre = titre;
        this.cathegorieS = cathegorie2;
    }
        public Post() {

    }

    @Override
    public String toString() {
        return getId_post()+" "+getSujet()+" "+getTitre()+" "+getDate()+" "+getCathegorieS();

    }
    

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }



    public int getCathegorieS() {
        return cathegorieS;
    }

    public void setCathegorieS(int cathegorieS) {
        this.cathegorieS = cathegorieS;
    }
    
    
    
    
}
