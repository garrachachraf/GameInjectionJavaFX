/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gamehub.services;

import edu.esprit.gamehub.iservices.IService;
import edu.esprit.gamehub.iservices.IUserService;
import edu.esprit.gamehub.models.Compte;
import edu.esprit.gamehub.technique.DataSource;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mehdi
 */
public class CompteService implements IUserService{

    private Connection connection;
    private PreparedStatement ps;

    public CompteService() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void add(Compte compte) {
        String req = "insert into compte (nom,prenom,date_de_naissance,email,pseudo,mot_de_passe,etat,points,rank,image,nombre_de_signalisation) values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            File file = compte.getImage();
            FileInputStream input = new FileInputStream(file);
            
            java.util.Date utilDate = compte.getDate_de_naissance();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            
            ps = connection.prepareStatement(req);
            ps.setString(1, compte.getNom());
            ps.setString(2, compte.getPrenom());
            ps.setDate(3,sqlDate);
            ps.setString(4, compte.getEmail());
            ps.setString(5,compte.getPseudo());
            ps.setString(6, compte.getMot_de_passe());
            ps.setInt(7, compte.getEtat());
            ps.setInt(8, compte.getPoints());
            ps.setInt(9, compte.getRank());
            ps.setBinaryStream(10,input);
            ps.setInt(11, compte.getNombre_signalisation());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Compte> getAll() {
        String req = "select * from compte";
        List<Compte> users = new ArrayList<>();
        try {
            ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                File tempFile = File.createTempFile("test", ".png", null);
                FileOutputStream fos = new FileOutputStream(tempFile);
                fos.write(rs.getBytes(11));
                Compte u = new Compte(rs.getInt(1)
                        , rs.getString(2)
                        , rs.getString(3)
                        , rs.getDate(4)
                        , rs.getString(5)
                        , rs.getString(6)
                        , rs.getString(7)
                        , rs.getInt(8)
                        , rs.getInt(9)
                        , rs.getInt(10)
                        , tempFile
                        , rs.getInt(12));
                users.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void delete(Integer idUser) {
        String req = "delete from compte where id_compte = ?";
        try {
            ps = connection.prepareStatement(req);
            ps.setInt(1, idUser);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Compte getById(Integer id) {
        String req = "select * from compte where id =?";
        Compte u = null;
        try {
            ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            File tempFile = File.createTempFile("test", ".png", null);
                FileOutputStream fos = new FileOutputStream(tempFile);
                fos.write(rs.getBytes(11));
                u = new Compte(rs.getInt(1)
                        , rs.getString(2)
                        , rs.getString(3)
                        , rs.getDate(4)
                        , rs.getString(5)
                        , rs.getString(6)
                        , rs.getString(7)
                        , rs.getInt(8)
                        , rs.getInt(9)
                        , rs.getInt(10)
                        , tempFile
                        , rs.getInt(12));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }
//
//    @Override
//    public Compte authentication(String login, String password) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public void edit(Compte t) {
        String req = "update compte set nom=?,prenom=?,date_de_naissance=?,email=?,pseudo=?,mot_de_passe=?,etat=?,points=?,rank=?,image=?,nombre_de_signalisation=? where id_compte = ?";
        try {
            
            File file = t.getImage();
            FileInputStream input = new FileInputStream(file);
            
            
            java.util.Date utilDate = t.getDate_de_naissance();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            
            ps = connection.prepareStatement(req);
            ps.setString(1, t.getNom());
            ps.setString(2, t.getPrenom());
            ps.setDate(3, sqlDate);
            ps.setString(4, t.getEmail());
            ps.setString(5, t.getPseudo());
            ps.setString(6, t.getMot_de_passe());
            ps.setInt(7, t.getEtat());
            ps.setInt(8, t.getPoints());
            ps.setInt(9, t.getRank());
            ps.setBinaryStream(10, input);
            ps.setInt(11, t.getNombre_signalisation());
            ps.setInt(12, t.getId_compte());
            
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
