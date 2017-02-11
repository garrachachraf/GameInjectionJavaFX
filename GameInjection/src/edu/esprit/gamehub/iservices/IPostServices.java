/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gamehub.iservices;

import edu.esprit.gamehub.models.Post;
import java.util.List;

/**
 *
 * @author ahmed
 */
public interface IPostServices {
 void addPost(Post p);
 void delete(int id_post);
 List<Post> showPosts();
 Post getPostbyid(int id);
}
