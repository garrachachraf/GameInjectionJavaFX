/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gamehub.tests;

import edu.esprit.gamehub.iservices.IService;
import edu.esprit.gamehub.iservices.IUserService;
import edu.esprit.gamehub.models.Compte;
import edu.esprit.gamehub.services.CompteService;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import javax.imageio.ImageIO;

/**
 *
 * @author Mehdi
 */
public class Test {

    public static void main(String[] args) {
       /* User user = new User("majri", "foued");
        IUserService userService = new UserService();
        userService.add(user);
        userService.delete(2);
        userService.getAll().forEach(System.out::println);*/
        
       
       Date birth=new Date();
       birth.setDate(13);
       birth.setMonth(06); //months from 0 ---> 11
       birth.setYear(95);  //years +1900
       
       
        Compte p = new Compte("Assal","Ahmed houssem",birth,"rey199677@esprit.tn","pseudo","hehehe",1,500,1,new File("C:\\Users\\Bloodthirst\\Desktop\\layouts RESSOURCES\\hand.png"),10);
        IUserService productService = new CompteService();
        p.setId_compte(1);
        productService.edit(p);
        File test=productService.getAll().stream().findFirst().get().getImage();
        
                try {
         
        BufferedImage image = ImageIO.read(test);
        ImageIO.write(image, "png", new File("C:\\Users\\Bloodthirst\\Desktop\\layouts RESSOURCES\\hand_Res.png"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
                
        
    }
}
