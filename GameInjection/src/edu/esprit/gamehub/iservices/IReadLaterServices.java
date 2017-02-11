/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gamehub.iservices;

import edu.esprit.gamehub.models.ReadLater;
import java.util.List;

/**
 *
 * @author ahmed
 */
public interface IReadLaterServices {
    void addtolist(ReadLater rl);
    List<ReadLater> showlist();
    void delete(int id_post,int id_compte);
    
    
}
