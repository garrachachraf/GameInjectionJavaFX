/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gamehub.iservices;

import edu.esprit.gamehub.models.Compte;

/**
 *
 * @author Mehdi
 */
public interface IUserService extends IService<Compte, Integer> {

    //User authentication(String login, String password);
    void edit (Compte t);
}
