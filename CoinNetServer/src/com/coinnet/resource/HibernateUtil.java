/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.resource;

import com.coinnet.entity.Account;
import com.coinnet.entity.BankAccount;
import com.coinnet.entity.Admin;
import com.coinnet.entity.AdminBankCompany;
import com.coinnet.entity.AdminCompany;
import com.coinnet.entity.Advertiesment;
import com.coinnet.entity.Bank;
import com.coinnet.entity.BankAdmin;
import com.coinnet.entity.BankCompany;
import com.coinnet.entity.Chat;
import com.coinnet.entity.ChatAccount;
import com.coinnet.entity.Company;
import com.coinnet.entity.Customer;
import com.coinnet.entity.DrawTicket;
import com.coinnet.entity.EcoAd;
import com.coinnet.entity.PublishTicket;
import com.coinnet.entity.Ticket;
import java.io.File;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Vidurajith
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static StandardServiceRegistry registry;
    
    static {
        try {
            // Create the HibernateUtil from standard (hibernate.cfg.xml) 
            // config file.
            registry=new StandardServiceRegistryBuilder().loadProperties(new File("settings/hibernate.properties")).build();
            
            sessionFactory = new MetadataSources(registry)
                    .addAnnotatedClass(Customer.class)
                    .addAnnotatedClass(Account.class)
                    .addAnnotatedClass(Chat.class)
                    .addAnnotatedClass(ChatAccount.class)
                    .addAnnotatedClass(BankAccount.class)
                    .addAnnotatedClass(Admin.class)
                    .addAnnotatedClass(Bank.class)
                    .addAnnotatedClass(BankAdmin.class)
                    .addAnnotatedClass(Company.class)
                    .addAnnotatedClass(BankCompany.class)
                    .addAnnotatedClass(Advertiesment.class)
                    .addAnnotatedClass(EcoAd.class)
                    .addAnnotatedClass(AdminCompany.class)
                    .addAnnotatedClass(AdminBankCompany.class)
                    .addAnnotatedClass(Ticket.class)
                    .addAnnotatedClass(PublishTicket.class)
                    .addAnnotatedClass(DrawTicket.class)
                    
                    .buildMetadata().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            StandardServiceRegistryBuilder.destroy(registry);
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory().openSession();
    }
}
