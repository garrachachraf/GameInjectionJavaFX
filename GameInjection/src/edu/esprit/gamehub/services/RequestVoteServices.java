/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gamehub.services;

import edu.esprit.gamehub.iservices.IRequestVoteServices;
import edu.esprit.gamehub.models.RatingPost;
import edu.esprit.gamehub.models.RequestVote;
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
public class RequestVoteServices implements IRequestVoteServices{
    private Connection connection;
    private PreparedStatement pst;

    public RequestVoteServices() {
        connection = DataSource.getInstance().getConnection();
    }


    @Override
    public void vote(RequestVote RV) {
        List<RequestVote>R = new ArrayList<>(); 
        String req1 = "SELECT * FROM `request_vote` WHERE id_compte= ? AND id_request=?";
        try {
            pst = connection.prepareStatement(req1);
            pst.setInt(1,RV.getId_compte());
            pst.setInt(2,RV.getId_request());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
        RequestVote r =new RequestVote(rs.getInt(1),rs.getInt(2),rs.getInt(3));
        R.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        System.out.println(R.stream().count());
        if(R.stream().count()==0){
        String req = "INSERT INTO `request_vote`(`id_request`, `id_compte`, `answer`) VALUES(?,?,?)";
        try {
            
            pst = connection.prepareStatement(req);
            pst.setInt(2,RV.getId_compte());
            pst.setInt(1,RV.getId_request());
            pst.setDouble(3,RV.getVote());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        else
        {
        String req = "UPDATE `request_vote` SET answer=? WHERE id_compte= ? AND id_request=?";
        try {
            
            pst = connection.prepareStatement(req);
            pst.setInt(2,RV.getId_compte());
            pst.setInt(3,RV.getId_request());
            pst.setDouble(1,RV.getVote());
         
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        }    }

    @Override
    public int results(int id_request) {
       String req = "SELECT SUM(answer) as sum FROM `request_vote` WHERE id_request= ? ";
      int r=0;
        try {
          
            pst = connection.prepareStatement(req);
            pst.setInt(1,id_request);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
            r = Integer.parseInt(rs.getString("sum"));

            }
            /////////
                ////////
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;    }
    
}
