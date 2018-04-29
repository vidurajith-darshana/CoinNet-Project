/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.business.custom.impl;

import com.coinnet.business.custom.AdminBO;
import com.coinnet.dto.AdminDTO;
import com.coinnet.entity.Admin;
import com.coinnet.repository.RepositoryFactory;
import com.coinnet.repository.custom.AdminRepository;
import com.coinnet.resource.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Vidurajith
 */
public class AdminBOImpl implements AdminBO{

    private AdminRepository adminRepository;

    public AdminBOImpl() {
        
        adminRepository=(AdminRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ADMIN);
    }
    
    
    
    @Override
    public boolean checkLogin(String email, String password) throws Exception {
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            adminRepository.setSession(session);
            boolean result=adminRepository.checkLogin(email, password);
            
            if(result){
                session.getTransaction().commit();
                session.close();
                return true;
            }else{
                session.getTransaction().rollback();
                session.close();
                return false;
            }
        }
        
    }

    @Override
    public List<AdminDTO> getAll() throws Exception {
        
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            
            session.beginTransaction();
            adminRepository.setSession(session);
            List<Admin> adminResult=adminRepository.getAll();
            List<AdminDTO> admins=new ArrayList<>();
            for (Admin admin : adminResult) {
                admins.add(new AdminDTO(admin.getAdminId(),admin.getName(),admin.getPic(),admin.getAddress(),admin.getContact(), admin.getEmail(),admin.getPassword(),admin.getPayment()));
            }
            session.close();
            return admins;
        }
        
    }

    @Override
    public AdminDTO getAdminDetail(String email, String password) throws Exception {
        
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            adminRepository.setSession(session);
            Admin admin= adminRepository.getAdminDetail(email, password);
            AdminDTO adminDTO=new AdminDTO(admin.getAdminId(),admin.getName(),admin.getPic(),admin.getAddress(),admin.getContact(),admin.getEmail(),admin.getPassword(), admin.getPayment());
            session.close();
            return adminDTO;
        }
    }
    
}
