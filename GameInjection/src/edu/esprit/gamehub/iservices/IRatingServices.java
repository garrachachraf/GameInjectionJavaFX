/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gamehub.iservices;

import edu.esprit.gamehub.models.Post;
import edu.esprit.gamehub.models.RatingPost;
import edu.esprit.gamehub.models.ReadLater;
import java.util.List;

/**
 *
 * @author ahmed
 */
public interface IRatingServices {
    void addtolist(RatingPost r);
    double showrate(int id_post,int id_compte);
    void delete(int id_post,int id_compte);   
}
