/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gamehub.iservices;

import edu.esprit.gamehub.models.CathegorieRequest;
import edu.esprit.gamehub.models.Post;
import java.util.List;

/**
 *
 * @author ahmed
 */
public interface ICathegorieRequest {
 void addRequest(CathegorieRequest c);
 void delete(int id_request);
 List<CathegorieRequest> showrequests();
 CathegorieRequest showrequestbyid(int id_request);
}
