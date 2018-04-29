/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.service.custom;

import com.coinnet.dto.BankAdminDTO;
import com.coinnet.service.SuperService;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public interface BankAdminService extends SuperService{
    
    public List<BankAdminDTO> getAll()throws Exception;
}
