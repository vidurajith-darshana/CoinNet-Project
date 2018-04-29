/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.business.custom;

import com.coinnet.business.SuperBO;
import com.coinnet.dto.AdminDTO;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public interface AdminBO extends SuperBO{
    
    public boolean checkLogin(String email,String password)throws Exception;
    
    public List<AdminDTO> getAll()throws Exception;
    
    public AdminDTO getAdminDetail(String email,String password)throws Exception;
    
}
