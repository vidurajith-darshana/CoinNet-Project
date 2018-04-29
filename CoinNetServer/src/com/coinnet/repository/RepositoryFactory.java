/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.repository;

import com.coinnet.repository.custom.impl.AccountRepositoryImpl;
import com.coinnet.repository.custom.impl.AdminBankCompanyRepositoryImpl;
import com.coinnet.repository.custom.impl.AdminCompanyRepositoryImpl;
import com.coinnet.repository.custom.impl.AdminRepositoryImpl;
import com.coinnet.repository.custom.impl.AdvertiesmentRepositoryImpl;
import com.coinnet.repository.custom.impl.BankAccountRepositoryImpl;
import com.coinnet.repository.custom.impl.BankAdminRepositoryImpl;
import com.coinnet.repository.custom.impl.BankCompanyRepositoryImpl;
import com.coinnet.repository.custom.impl.BankRepositoryImpl;
import com.coinnet.repository.custom.impl.ChatAccountRepositoryImpl;
import com.coinnet.repository.custom.impl.ChatRepositoryImpl;
import com.coinnet.repository.custom.impl.CompanyRepositoryImpl;
import com.coinnet.repository.custom.impl.CustomerRepositoryImpl;
import com.coinnet.repository.custom.impl.DrawTicketRepositoryImpl;
import com.coinnet.repository.custom.impl.EcoAdRepositoryImpl;
import com.coinnet.repository.custom.impl.PublishTicketRepositoryImpl;
import com.coinnet.repository.custom.impl.TicketRepositoryImpl;

/**
 *
 * @author Vidurajith
 */
public class RepositoryFactory {
    
    private static RepositoryFactory repositoryFactory;
    
    private RepositoryFactory(){
        
    }
    
    public enum RepositoryTypes{
        CUSTOMER,ACCOUNT,CHAT,CHATACCOUNT,BANKACCOUNT,ADMIN,BANK,BANKADMIN,COMPANY,BANKCOMPANY,ADMINCOMPNAY,ADMINBANKCOMPANY,ECOAD,ADVERTIESMENT,PUBLISHTICKET,TICKET,DRAWTICKET
    }
    
    public static RepositoryFactory getInstance(){
        if(repositoryFactory==null){
            repositoryFactory=new RepositoryFactory();
        }
        return repositoryFactory;
    }
    
    public SuperRepository getRepository(RepositoryTypes repositoryTypes){
        
        switch(repositoryTypes){
            case CHAT:
                return new ChatRepositoryImpl();
            case CUSTOMER:
                return new CustomerRepositoryImpl();
            case ACCOUNT:
                return new AccountRepositoryImpl();
            case CHATACCOUNT:
                return new ChatAccountRepositoryImpl();
            case BANKACCOUNT:
                return new BankAccountRepositoryImpl();
            case ADMIN:
                return new AdminRepositoryImpl();
            case BANK:
                return new BankRepositoryImpl();
            case BANKADMIN:
                return new BankAdminRepositoryImpl();
            case COMPANY:
                return new CompanyRepositoryImpl();
            case BANKCOMPANY:
                return new BankCompanyRepositoryImpl();
            case ADMINBANKCOMPANY:
                return new AdminBankCompanyRepositoryImpl();
            case ADMINCOMPNAY:
                return new AdminCompanyRepositoryImpl();
            case ADVERTIESMENT:
                return new AdvertiesmentRepositoryImpl();
            case ECOAD:
                return new EcoAdRepositoryImpl();
            case PUBLISHTICKET:
                return new PublishTicketRepositoryImpl();
            case TICKET:
                return new TicketRepositoryImpl();
            case DRAWTICKET:
                return new DrawTicketRepositoryImpl();
            default:
                return null;
        }
        
    }
    
}
