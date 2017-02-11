/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gamehub.services;

import edu.esprit.gamehub.iservices.IRatingServices;
import edu.esprit.gamehub.models.Post;
import edu.esprit.gamehub.models.RatingPost;
import edu.esprit.gamehub.models.ReadLater;
import edu.esprit.gamehub.technique.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahmed
 */
public class RatingPostServices implements IRatingServices {
    private Connection connection;
    private PreparedStatement pst;

    public RatingPostServices() {
        connection = DataSource.getInstance().getConnection();
    }




    

    @Override
    public void addtolist(RatingPost r) {
        List<RatingPost> R = new ArrayList<>(); 
        String req1 = "select * from `post_rate` WHERE id_compte= ? AND id_post=?";
        try {
            pst = connection.prepareStatement(req1);
            pst.setInt(1,r.getId_compte());
            pst.setInt(2,r.getId_post());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                RatingPost rl = new RatingPost(r.getId_compte(), r.getId_post(), r.getValeur());
                R.add(rl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        System.out.println(R.stream().count());
        if(R.stream().count()==0){
        String req = "INSERT INTO `post_rate`(`id_compte`, `id_post`,valeur) VALUES(?,?,?)";
        try {
            
            pst = connection.prepareStatement(req);
            pst.setInt(1,r.getId_compte());
            pst.setInt(2,r.getId_post());
            pst.setDouble(3,r.getValeur());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        else
        {
        String req = "UPDATE `post_rate` SET valeur=? WHERE id_compte= ? AND id_post=?";
        try {
            
            pst = connection.prepareStatement(req);
            pst.setInt(2,r.getId_compte());
            pst.setInt(3,r.getId_post());
            pst.setDouble(1,r.getValeur());
         
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        }
    }

    @Override
    public double showrate(int id_compte, int id_post) {
       String req = "select * from `post_rate` WHERE id_compte= ? AND id_post=? ";
      double r=0;
        try {
          
            pst = connection.prepareStatement(req);
            pst.setInt(1,id_compte);
            pst.setInt(2,id_post);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                 r = rs.getDouble(3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public void delete(int id_post, int id_compte) {
  String req = "DELETE FROM `post_rate` WHERE id_compte=? AND id_post=?";
        try {
            pst = connection.prepareStatement(req);
            pst.setInt(1,id_compte);
            pst.setInt(2,id_post);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }     
    }
    
}
