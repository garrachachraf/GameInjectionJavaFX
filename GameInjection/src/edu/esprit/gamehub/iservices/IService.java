/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gamehub.iservices;

import java.util.List;

/**
 *
 * @author Mehdi
 */
public interface IService<T, R> {

    void add(T t);

    void delete(R r);

    List<T> getAll();

    T getById(R r);
}
