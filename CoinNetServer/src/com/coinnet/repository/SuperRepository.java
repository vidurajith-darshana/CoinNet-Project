/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.repository;

import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Vidurajith
 */
public interface SuperRepository<T,ID> {
    
    public void setSession(Session session);
    
    public boolean save(T t)throws Exception;
    
    public List<T> getAll()throws Exception;
    
    public boolean checkLogin(String email,String password)throws Exception;
    
}
