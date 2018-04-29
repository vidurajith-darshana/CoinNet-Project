/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.business.custom.impl;

import com.coinnet.business.custom.CompanyBO;
import com.coinnet.dto.AdminDTO;
import com.coinnet.dto.AdvertiesmentDTO;
import com.coinnet.dto.BankCompanyDTO;
import com.coinnet.dto.BankDTO;
import com.coinnet.dto.CompanyDTO;
import com.coinnet.dto.EcoAdDTO;
import com.coinnet.entity.Admin;
import com.coinnet.entity.AdminBankCompany;
import com.coinnet.entity.AdminCompany;
import com.coinnet.entity.Advertiesment;
import com.coinnet.entity.Bank;
import com.coinnet.entity.BankCompany;
import com.coinnet.entity.Company;
import com.coinnet.entity.EcoAd;
import com.coinnet.repository.RepositoryFactory;
import com.coinnet.repository.custom.AdminBankCompanyRepository;
import com.coinnet.repository.custom.AdminCompanyRepository;
import com.coinnet.repository.custom.AdvertiesmentRepository;
import com.coinnet.repository.custom.BankCompanyRepository;
import com.coinnet.repository.custom.CompanyRepository;
import com.coinnet.repository.custom.EcoAdRepository;
import com.coinnet.resource.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Vidurajith
 */
public class CompanyBOImpl implements CompanyBO{

    private CompanyRepository companyRepository;
    private BankCompanyRepository bankCompanyRepository;
    private AdminCompanyRepository adminCompanyRepository;
    private AdminBankCompanyRepository adminBankCompanyRepository;
    private AdvertiesmentRepository advertiesmentRepository;
    private EcoAdRepository ecoAdRepository;
    
    public CompanyBOImpl() {
        
        companyRepository=(CompanyRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.COMPANY);
        bankCompanyRepository=(BankCompanyRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.BANKCOMPANY);
        adminCompanyRepository=(AdminCompanyRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ADMINCOMPNAY);
        adminBankCompanyRepository=(AdminBankCompanyRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ADMINBANKCOMPANY);
        advertiesmentRepository=(AdvertiesmentRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ADVERTIESMENT);
        ecoAdRepository=(EcoAdRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ECOAD);
    }

    
    
    @Override
    public boolean saveCompany(CompanyDTO companyDTO, BankCompanyDTO bankCompanyDTO,BankDTO bankDTO,List<AdminDTO> adminList) throws Exception {
        
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
           
            companyRepository.setSession(session);
            bankCompanyRepository.setSession(session);
            adminBankCompanyRepository.setSession(session);
            adminCompanyRepository.setSession(session);
            
            String pic="";
            if(!companyDTO.getPic().equals("")){
                pic=companyDTO.getPic();
            }
            
            boolean isDone=false;
            
            Company company=new Company(companyDTO.getName(), companyDTO.getAddress(),companyDTO.getContact(),companyDTO.getEmail(), companyDTO.getPassword(), companyDTO.getPayment(), companyDTO.getServiceType(),pic);
            BankCompany bankCompany=new BankCompany(new Bank(bankDTO.getBid(),bankDTO.getName(),bankDTO.getPic(),bankDTO.getRate()), company,companyDTO.getPayment()*50/100,bankCompanyDTO.getTransaction_type(),bankCompanyDTO.getDate(),bankCompanyDTO.getTime());
            
            if(companyRepository.save(company)){
                if(bankCompanyRepository.save(bankCompany)){
                    int count=0;
                    for(int i=1;i<4;i++){
                        session.flush();
                        session.clear();
                        AdminDTO adminDTO=adminList.get(i-1);
                        AdminCompany adminCompany=new AdminCompany(new Admin(adminDTO.getAdminID(),adminDTO.getName(),adminDTO.getPic(),adminDTO.getAddress(),adminDTO.getContact(),adminDTO.getEmail(),adminDTO.getPassword(),adminDTO.getReal_payment()), company,bankCompanyDTO.getDate(),(companyDTO.getPayment()*50/100)/3,2);
                        if(!adminCompanyRepository.save(adminCompany)){
                            break;
                        }else{
                            session.flush();
                            session.clear();
                            if(!adminBankCompanyRepository.save(new AdminBankCompany(new Bank(bankDTO.getBid(),bankDTO.getName(),bankDTO.getPic(),bankDTO.getRate()), adminCompany,(companyDTO.getPayment()*50/100)/3,"deposite",bankCompanyDTO.getDate(),bankCompanyDTO.getTime() ))){
                                break;
                            }else{
                                count++;
                            }
                        }
                    }
                    if(count==3){
                        isDone=true;
                    }
                }
            }
            if(isDone){
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
    public List<CompanyDTO> getAll() throws Exception {
        
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            
            companyRepository.setSession(session);
            List<Company> list=companyRepository.getAll();
            List<CompanyDTO> comList=new ArrayList<>();
            for (Company company : list) {
                comList.add(new CompanyDTO(company.getComId(),company.getName(), company.getAddress(),company.getContact(),company.getEmail(),company.getPassword(),company.getPayment(),company.getServiceType(),company.getPic()));
            }
            session.close();
            return comList;
        }
        
    }

    @Override
    public CompanyDTO getCompany(String email,String password) throws Exception {
        
        CompanyDTO comDTO=null;
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            
            companyRepository.setSession(session);
            Company company=companyRepository.getCompany(email,password);
            if(company!=null){
                comDTO=new CompanyDTO(company.getComId(), company.getName(),company.getAddress(),company.getContact(),company.getEmail(),company.getPassword(),company.getPayment(),company.getServiceType(),company.getPic());
            }
            
            session.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return comDTO;
    }

    @Override
    public boolean saveEcoAdvertiesement(AdvertiesmentDTO advertiesmentDTO, EcoAdDTO ecoAdDTO,CompanyDTO companyDTO,BankDTO bankDTO) throws Exception {
        
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            
            advertiesmentRepository.setSession(session);
            ecoAdRepository.setSession(session);
            bankCompanyRepository.setSession(session);
            adminBankCompanyRepository.setSession(session);
            adminCompanyRepository.setSession(session);
            
            Company company=new Company(companyDTO.getComID(),"","","","","", 0, "",""); 
            Advertiesment advertiesment=new Advertiesment(company,advertiesmentDTO.getDate(),advertiesmentDTO.getTime(),advertiesmentDTO.getPayment(),advertiesmentDTO.getServiceType());
            EcoAd ecoAd=new EcoAd(advertiesment,ecoAdDTO.getImage(),ecoAdDTO.getBackImage(),ecoAdDTO.getAreaFontColor(),ecoAdDTO.getAreaFontSize(), ecoAdDTO.isIsAreaItalic(),ecoAdDTO.isIsAreaReg(),ecoAdDTO.isIsAreaBold(),ecoAdDTO.getAreaFamily(),ecoAdDTO.getLblBack(),ecoAdDTO.getLblText(),ecoAdDTO.getAreaText(),ecoAdDTO.getLblFontColor(),ecoAdDTO.getLblFontSize(),ecoAdDTO.getLblFamily(),ecoAdDTO.isIsLblBold(),ecoAdDTO.isIsLblItalic(),ecoAdDTO.isIsLblReg(),ecoAdDTO.getBackColor());
            
            boolean isDone=false;
            
            if(advertiesmentRepository.save(advertiesment)){
                if(ecoAdRepository.save(ecoAd)){
                    int count=0;
                    for(int i=1;i<4;i++){
                        AdminCompany adminCompany=new AdminCompany(new Admin(i,"","","","","","",0), company, advertiesment.getDates(),advertiesment.getPayment()/3,3);
                        if(!adminCompanyRepository.save(adminCompany)){
                            break;
                        }else{
                            if(!adminBankCompanyRepository.save(new AdminBankCompany(new Bank(bankDTO.getBid(),"","", 0), adminCompany, advertiesment.getPayment()/3,"deposite",advertiesment.getDates(),advertiesment.getTimes()))){
                                break;
                            }
                        }
                        count++;
                    }
                    if(count==3){
                        if(bankCompanyRepository.save(new BankCompany(new Bank(bankDTO.getBid(),"","",0), company,advertiesment.getPayment(),"withdraw",advertiesment.getDates(),advertiesment.getTimes()))){
                            
                            isDone=true;
                        }
                    }
                }
            }
            if(isDone){
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
    public boolean updateImage(String imgName, int cid) throws Exception {
        
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            companyRepository.setSession(session);
            boolean isUpdate= companyRepository.updateImage(imgName, cid);
            
            if(isUpdate){
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
    public CompanyDTO getUserDetail(String email) throws Exception {
        
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            companyRepository.setSession(session);
            Company company=companyRepository.getUserDetail(email);
            session.close();
            if(company!=null){
                return new CompanyDTO(company.getComId(),company.getName(), company.getAddress(),company.getContact(),company.getEmail(),company.getPassword(),company.getPayment(),company.getServiceType(),company.getPic());
            }
            return null;
            
        }
    }
    
}
