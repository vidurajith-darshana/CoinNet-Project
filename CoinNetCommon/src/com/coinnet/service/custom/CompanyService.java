/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.service.custom;

import com.coinnet.dto.AdminDTO;
import com.coinnet.dto.BankCompanyDTO;
import com.coinnet.dto.BankDTO;
import com.coinnet.dto.CompanyDTO;
import com.coinnet.service.SuperService;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public interface CompanyService extends SuperService{
    
    public boolean saveCompany(CompanyDTO companyDTO,BankCompanyDTO bankCompanyDTO,BankDTO bankDTO,List<AdminDTO> adminList)throws Exception;
    
    public List<CompanyDTO> getAll()throws Exception;
    
    public CompanyDTO getCompany(String email,String password)throws Exception;

    public void saveImage(byte[] data,String name)throws Exception;
    
    public byte[] getImage(String email) throws Exception;
    
    public boolean updateImage(String imgName,int cid)throws Exception;
    
    public CompanyDTO getUserDetail(String email)throws Exception;

}
