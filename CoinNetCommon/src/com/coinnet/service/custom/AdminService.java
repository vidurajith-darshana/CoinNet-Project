/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.service.custom;

import com.coinnet.dto.AdminDTO;
import com.coinnet.service.SuperService;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public interface AdminService extends SuperService{
    
    public boolean checkLogin(String email,String password)throws Exception;
    
    public List<AdminDTO> getAll()throws Exception;
    
    public byte[] getAdminImage(String name)throws Exception;
    
    public AdminDTO getAdminDetail(String email,String password)throws Exception;
   
}
