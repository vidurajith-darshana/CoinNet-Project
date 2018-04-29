/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.business.custom.impl;

import com.coinnet.business.custom.ChatAccountBO;
import com.coinnet.dto.ChatAccountDTO;
import com.coinnet.entity.Account;
import com.coinnet.entity.Chat;
import com.coinnet.entity.ChatAccount;
import com.coinnet.entity.Customer;
import com.coinnet.repository.RepositoryFactory;
import com.coinnet.repository.custom.ChatAccountRepository;
import com.coinnet.resource.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Vidurajith
 */
public class ChatAccountBOImpl implements ChatAccountBO{

    private ChatAccountRepository chatAccountRepository;

    public ChatAccountBOImpl() {
        chatAccountRepository=(ChatAccountRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.CHATACCOUNT);
    }
    
    

    @Override
    public List<ChatAccountDTO> getAll() throws Exception {
        
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            
            chatAccountRepository.setSession(session);
            List<ChatAccountDTO> chatAccounts=new ArrayList<>();
        
            List<ChatAccount> list=chatAccountRepository.getAll();
            for (ChatAccount chatAccount : list) {

                ChatAccountDTO chatAccountDTO=new ChatAccountDTO(chatAccount.getChat().getChatId(),chatAccount.getAccount().getAid(),chatAccount.getReceiveAid());
                chatAccounts.add(chatAccountDTO);
            }
            session.close();
            return chatAccounts;
            
        }
        
    }
    
}
