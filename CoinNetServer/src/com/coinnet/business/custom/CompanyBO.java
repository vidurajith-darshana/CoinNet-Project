/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.business.custom;

import com.coinnet.business.SuperBO;
import com.coinnet.dto.AdminDTO;
import com.coinnet.dto.AdvertiesmentDTO;
import com.coinnet.dto.BankCompanyDTO;
import com.coinnet.dto.BankDTO;
import com.coinnet.dto.CompanyDTO;
import com.coinnet.dto.EcoAdDTO;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public interface CompanyBO extends SuperBO{
    
    public boolean saveCompany(CompanyDTO companyDTO,BankCompanyDTO bankCompanyDTO,BankDTO bankDTO,List<AdminDTO> adminList)throws Exception;
    
    public List<CompanyDTO> getAll()throws Exception;
    
    public boolean updateImage(String imgName,int cid)throws Exception;
    
    public CompanyDTO getCompany(String email,String password) throws Exception;
    
    public boolean saveEcoAdvertiesement(AdvertiesmentDTO advertiesmentDTO,EcoAdDTO ecoAdDTO,CompanyDTO companyDTO,BankDTO bankDTO)throws Exception;
    
    public CompanyDTO getUserDetail(String email)throws Exception;
}
