/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.business.custom;

import com.coinnet.business.SuperBO;
import com.coinnet.dto.BankAdminDTO;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public interface BankAdminBO extends SuperBO{
    
    public List<BankAdminDTO> getAll()throws Exception;
    
}
