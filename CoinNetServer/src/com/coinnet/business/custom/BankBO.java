/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.business.custom;

import com.coinnet.business.SuperBO;
import com.coinnet.dto.BankDTO;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public interface BankBO extends SuperBO{
    
    public List<BankDTO> getAll()throws Exception;
}
