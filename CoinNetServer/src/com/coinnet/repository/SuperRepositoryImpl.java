/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Vidurajith
 */
public abstract class SuperRepositoryImpl<T,ID extends Serializable> implements SuperRepository<T, ID>{
    
    protected Session session;
    private Class<T> entity;
    
    public SuperRepositoryImpl(){
        entity=(Class<T>) ((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
    }
    
    @Override
    public void setSession(Session session){
        this.session=session;
    }
    
    @Override
    public boolean save(T t)throws Exception{
        
        return (session.save(t)!=null);
    }
    
    @Override
    public List<T> getAll()throws Exception{
        
        return session.createQuery("From "+entity.getSimpleName()).list();
        
    }

    @Override
    public boolean checkLogin(String email, String password) throws Exception {
        
        List<T> t= (session.createQuery("FROM "+entity.getSimpleName()+" WHERE email='"+email+"' and password='"+password+"'").list());
        if(t.isEmpty()){
            return false;
        }
        return true;
    }
}
