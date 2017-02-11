/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gamehub.services;

import edu.esprit.gamehub.iservices.IPostServices;
import edu.esprit.gamehub.models.Post;
import edu.esprit.gamehub.technique.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahmed
 */
public class PostServices implements IPostServices{
    private Connection connection;
    private PreparedStatement pst;

    public PostServices() {
        connection = DataSource.getInstance().getConnection();
    }


    @Override
    public void addPost(Post post) {
        String req = "INSERT INTO `post`(`sujet`, `titre`, `date`, `cathegorie_specifique`)VALUES (?,?,CURRENT_TIMESTAMP(),?)";
        try {
            
            pst = connection.prepareStatement(req);
            pst.setString(1,post.getSujet());
            pst.setString(2,post.getTitre());
            //pst.setDate(3,(Date) post.getDate());
            //pst.setString(3,post.getCathegorieG());
            pst.setInt(3,post.getCathegorieS());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id_post) {
        String req = "delete from post where id_post = ?";
        try {
            pst = connection.prepareStatement(req);
            pst.setInt(1, id_post);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Post> showPosts() {
        
        String req = "select * from post";
        List<Post> posts = new ArrayList<>();
        try {
            pst = connection.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Post post = new Post(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getTimestamp(4),rs.getInt(5));
                posts.add(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return posts;
        
    }
    
        @Override
    public Post getPostbyid(int id) {
        
        String req = "SELECT * FROM `post` WHERE id_post= ? ";
        List<Post> ls = new ArrayList<>();
        try {
            pst = connection.prepareStatement(req);
            pst.setInt(1,id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Post post = new Post(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getTimestamp(4),rs.getInt(5));
                ls.add(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls.stream().findFirst().get(); 
        
    }
     
         
    
}
