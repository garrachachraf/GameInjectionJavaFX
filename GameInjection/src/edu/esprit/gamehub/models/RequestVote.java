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
public class RequestVote {
    private int id_request;
    private int id_compte;
    private int vote;

    public RequestVote(int id_request, int id_compte, int vote) {
        this.id_request = id_request;
        this.id_compte = id_compte;
        this.vote = vote;
    }

    public int getId_request() {
        return id_request;
    }

    public void setId_request(int id_request) {
        this.id_request = id_request;
    }

    public int getId_compte() {
        return id_compte;
    }

    public void setId_compte(int id_compte) {
        this.id_compte = id_compte;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    @Override
    public String toString() {
        return "RequestVote{" + "id_request=" + id_request + ", id_compte=" + id_compte + ", vote=" + vote + '}';
    }
    
    
}
