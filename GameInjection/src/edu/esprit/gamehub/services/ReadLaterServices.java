/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gamehub.services;

import edu.esprit.gamehub.iservices.IReadLaterServices;
import edu.esprit.gamehub.models.Post;
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
public class ReadLaterServices implements IReadLaterServices{
 private Connection connection;
 private PreparedStatement pst;
 public ReadLaterServices() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void addtolist(ReadLater rl) {
        String req = "INSERT INTO `read_later`(`id_post`, `id_compte`) VALUES(?,?)";
        try {
            pst = connection.prepareStatement(req);
            pst.setInt(2,rl.getId_compte());
            pst.setInt(1,rl.getId_post());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }

    @Override
    public List<ReadLater> showlist() {
        String req = "select * from read_later";
        List<ReadLater> readlater = new ArrayList<>();
        try {
            pst = connection.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ReadLater rl = new ReadLater(rs.getInt(1),rs.getInt(2));
                readlater.add(rl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return readlater;
            }

    @Override
    public void delete(int id_post, int id_compte) {
        String req = "DELETE FROM read_later WHERE id_compte= ? AND id_post=?";
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
