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
public class ReadLater {
   private int id_compte;
   private int id_post;

    public ReadLater( int id_post,int id_compte) {
        this.id_compte = id_compte;
        this.id_post = id_post;
    }

    public int getId_compte() {
        return id_compte;
    }

    public void setId_compte(int id_compte) {
        this.id_compte = id_compte;
    }

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    @Override
    public String toString() {
        return getId_compte()+" "+getId_post(); //To change body of generated methods, choose Tools | Templates.
    } 
}
