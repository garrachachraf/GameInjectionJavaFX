/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gamehub.services;

import edu.esprit.gamehub.iservices.ICathegorieSpecifiqueServices;
import edu.esprit.gamehub.models.CathegorieSpecifique;
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
public class CathegorieSpecifiqueServices implements ICathegorieSpecifiqueServices{
    private Connection connection;
    private PreparedStatement pst;

    public CathegorieSpecifiqueServices() {
        connection = DataSource.getInstance().getConnection();
    }
    @Override
    public void add(CathegorieSpecifique C) {
    String req = "INSERT INTO `cathegorie`(`nom`) VALUES (?)";

        try {
            
            pst = connection.prepareStatement(req);
            pst.setString(1,C.getNom());
            
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }

    @Override
    public CathegorieSpecifique show(int id) {
        String req = "SELECT * FROM `cathegorie` WHERE id= ? ";
        List<CathegorieSpecifique> ls = new ArrayList<>();
        try {
            pst = connection.prepareStatement(req);
            pst.setInt(1,id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                CathegorieSpecifique C = new CathegorieSpecifique(rs.getInt(1),rs.getString(2));
                ls.add(C);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls.stream().findFirst().get();
    }

    @Override
    public List<CathegorieSpecifique> showAll() {
        String req = "select * from cathegorie";
        List<CathegorieSpecifique> ls = new ArrayList<>();
        try {
            pst = connection.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                CathegorieSpecifique C = new CathegorieSpecifique(rs.getInt(1),rs.getString(2));
                ls.add(C);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }

    @Override
    public void delete(int id) {
        String req = "DELETE FROM `cathegorie` WHERE id= ?";
        try {
            pst = connection.prepareStatement(req);
            pst.setInt(1,id);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }    
    }
        @Override
    public int get_id_by_name(String nom) {
        String req = "SELECT * FROM `cathegorie` WHERE id= ? ";
        List<CathegorieSpecifique> ls = new ArrayList<>();
        try {
            pst = connection.prepareStatement(req);
            pst.setString(1,nom);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                CathegorieSpecifique C = new CathegorieSpecifique(rs.getInt(1),rs.getString(2));
                ls.add(C);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls.stream().findFirst().get().getId_cathegorie_specifique();    }
    
}
