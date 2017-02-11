/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gamehub.iservices;

import edu.esprit.gamehub.models.CathegorieSpecifique;
import java.util.List;

/**
 *
 * @author ahmed
 */
public interface ICathegorieSpecifiqueServices {
    void add(CathegorieSpecifique C);
    CathegorieSpecifique show(int id);
    List<CathegorieSpecifique> showAll();
    void delete(int id);
    int get_id_by_name(String nom);
}
