/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.service.custom;

import com.coinnet.dto.AdminBankCompanyDTO;
import com.coinnet.service.SuperService;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public interface AdminBankCompanyService extends SuperService{
    
    public List<AdminBankCompanyDTO> getAll()throws Exception;
    
}
