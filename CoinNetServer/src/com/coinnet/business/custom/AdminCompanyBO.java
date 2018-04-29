/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.business.custom;

import com.coinnet.business.SuperBO;
import com.coinnet.dto.AdminCompanyDTO;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public interface AdminCompanyBO extends SuperBO{
    
    public List<AdminCompanyDTO> getAll()throws Exception;
    
}
