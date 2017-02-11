/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gamehub.services;

import edu.esprit.gamehub.iservices.ICathegorieRequest;
import edu.esprit.gamehub.models.CathegorieRequest;
import edu.esprit.gamehub.models.Post;
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
public class CathegorieRequestServices implements ICathegorieRequest{
    private Connection connection;
    private PreparedStatement pst;

    public CathegorieRequestServices() {
        connection = DataSource.getInstance().getConnection();
    }
    @Override
    public void addRequest(CathegorieRequest c) {
        String req = "INSERT INTO `cathegorie_request`(`nom`, `date`, `id_compte`)VALUES (?,CURRENT_TIMESTAMP(),?)";
        try {
            
            pst = connection.prepareStatement(req);
            pst.setString(1,c.getNom());
            pst.setInt(2,c.getId_compte());
            
           
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id_request) {
        String req = "DELETE FROM `cathegorie_request` where id_request = ?";
        try {
            pst = connection.prepareStatement(req);
            pst.setInt(1, id_request);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }

    @Override
    public List<CathegorieRequest> showrequests() {
        String req = "select * from `cathegorie_request`";
        List<CathegorieRequest> requests = new ArrayList<>();
        try {
            pst = connection.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                CathegorieRequest CR = new CathegorieRequest(rs.getInt(1), rs.getString(2),rs.getTimestamp(3),rs.getInt(4));
                requests.add(CR);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return requests;
            }


    @Override
    public CathegorieRequest showrequestbyid(int id_request) {
   String req = "select * from `cathegorie_request` where id_request = ?";
   List<CathegorieRequest> requests = new ArrayList<>();
   
   try {
          
            pst = connection.prepareStatement(req);
            pst.setInt(1,id_request);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                 CathegorieRequest CR = new CathegorieRequest(rs.getInt(1), rs.getString(2),rs.getTimestamp(3),rs.getInt(4));
                requests.add(CR);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return requests.stream().findFirst().get();  
    }
    
}
