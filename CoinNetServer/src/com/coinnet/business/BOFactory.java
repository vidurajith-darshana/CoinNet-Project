/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.business;

import com.coinnet.business.custom.impl.AccountBOImpl;
import com.coinnet.business.custom.impl.AdminBOImpl;
import com.coinnet.business.custom.impl.AdminBankCompanyBOImpl;
import com.coinnet.business.custom.impl.AdminCompanyBOImpl;
import com.coinnet.business.custom.impl.BankAccountBOImpl;
import com.coinnet.business.custom.impl.BankAdminBOImpl;
import com.coinnet.business.custom.impl.BankBOImpl;
import com.coinnet.business.custom.impl.ChatAccountBOImpl;
import com.coinnet.business.custom.impl.ChatBOImpl;
import com.coinnet.business.custom.impl.CompanyBOImpl;
import com.coinnet.business.custom.impl.CustomerBOImpl;
import com.coinnet.business.custom.impl.DrawTicketBoImpl;
import com.coinnet.business.custom.impl.PublishTicketBOImpl;
import com.coinnet.business.custom.impl.TicketBOImpl;

/**
 *
 * @author Vidurajith
 */
public class BOFactory {
    
    private static BOFactory bOFactory;

    private BOFactory() {
    }
    
    public enum BOTypes{
        CUSTOMER,ACCOUNT,CHAT,CHATACCOUNT,ADMIN,BANK,BANKADMIN,COMPANY,ADMINBANKCOMPANY,ADMINCOMPANY,BANKACCOUNT,TICKET,PUBLISHTICKET,DRAW
    }
    
    public static BOFactory getInstance(){
        if(bOFactory==null){
            bOFactory=new BOFactory();
        }
        return bOFactory;
    }
    
    public SuperBO getBOTypes(BOTypes bOTypes){
        
        switch(bOTypes){
            case ACCOUNT:
                return new AccountBOImpl();
            case CHAT:
                return new ChatBOImpl();
            case CHATACCOUNT:
                return new ChatAccountBOImpl();
            case CUSTOMER:
                return new CustomerBOImpl();
            case ADMIN:
                return new AdminBOImpl();
            case BANK:
                return new BankBOImpl();
            case BANKADMIN:
                return new BankAdminBOImpl();
            case COMPANY:
                return new CompanyBOImpl();
            case ADMINBANKCOMPANY:
                return new AdminBankCompanyBOImpl();
            case ADMINCOMPANY:
                return new AdminCompanyBOImpl();
            case BANKACCOUNT:
                return new BankAccountBOImpl();
            case TICKET:
                return new TicketBOImpl();
            case PUBLISHTICKET:
                return new PublishTicketBOImpl();
            case DRAW:
                return new DrawTicketBoImpl();
            default:
                return null;
        }
    }
    
}
