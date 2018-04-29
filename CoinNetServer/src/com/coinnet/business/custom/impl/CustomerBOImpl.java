/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.business.custom.impl;

import com.coinnet.business.custom.CustomerBO;
import com.coinnet.dto.AccountDTO;
import com.coinnet.dto.BankDTO;
import com.coinnet.dto.CustomerBankDTO;
import com.coinnet.dto.CustomerDTO;
import com.coinnet.entity.Account;
import com.coinnet.entity.BankAccount;
import com.coinnet.entity.Bank;
import com.coinnet.entity.Customer;
import com.coinnet.repository.RepositoryFactory;
import com.coinnet.repository.custom.AccountRepository;
import com.coinnet.repository.custom.BankAccountRepository;
import com.coinnet.repository.custom.CustomerRepository;
import com.coinnet.resource.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Vidurajith
 */
public class CustomerBOImpl implements CustomerBO{

    private CustomerRepository customerRepository;
    private AccountRepository accountRepository;
    private BankAccountRepository bankAccountRepository;
    
    public CustomerBOImpl() {
        
        customerRepository=(CustomerRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.CUSTOMER);
        accountRepository=(AccountRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ACCOUNT);
        bankAccountRepository=(BankAccountRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.BANKACCOUNT);
    }
    
    
    
    @Override
    public boolean saveCustomer(CustomerDTO customerDTO,AccountDTO accountDTO,CustomerBankDTO customerBankDTO,BankDTO bankDTO) throws Exception {
        
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            
            customerRepository.setSession(session);
            accountRepository.setSession(session);
            bankAccountRepository.setSession(session);
            
            boolean result=false;
            
            Customer customer=new Customer(customerDTO.getName(), customerDTO.getAddress(), customerDTO.getPic(),customerDTO.getBirthday(),customerDTO.getContact());
            Account account=new Account(customer,accountDTO.getEmail(),accountDTO.getPassword(),accountDTO.getPayment());
            
            if(customerRepository.save(customer)){
                if(accountRepository.save(account)){
                    if(bankAccountRepository.save(new BankAccount(new Bank(customerBankDTO.getBid(),bankDTO.getName(),bankDTO.getPic(),bankDTO.getRate() ),account, customerBankDTO.getAmount(), customerBankDTO.getTransaction_type(),customerBankDTO.getDate(), customerBankDTO.getTime()))){
                        result=true;
                        session.getTransaction().commit();
                    }
                    
                }
            }
            if(!result){
                session.getTransaction().rollback();
            }
            return result;
        }
    }

    @Override
    public CustomerDTO getUserDetail(int cid) throws Exception {
        
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            customerRepository.setSession(session);
            Customer customer= customerRepository.getUserDetail(cid);
            CustomerDTO customerDTO=null;
            if(customer!=null){
                customerDTO=new CustomerDTO(customer.getCid(),customer.getName(),customer.getAddress(),customer.getBirthday(),customer.getContact(),customer.getPic());
            }
            
            session.close();
            return customerDTO;
        }
        
    }

    @Override
    public boolean updateImage(String imgName, int cid) throws Exception {
        
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            customerRepository.setSession(session);
            boolean isUpdate= customerRepository.updateImage(imgName, cid);
            
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
    public List<CustomerDTO> getAll() throws Exception {
        
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            customerRepository.setSession(session);
            List<Customer> list=customerRepository.getAll();
            List<CustomerDTO> custList=new ArrayList<>();
            for (Customer customer : list) {
                custList.add(new CustomerDTO(customer.getCid(),customer.getName(),customer.getAddress(),customer.getBirthday(),customer.getContact(), customer.getPic()));
            }
            session.close();
            return custList;
        }
    }

}
