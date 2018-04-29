/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.business.custom.impl;

import com.coinnet.business.custom.ChatBO;
import com.coinnet.dto.AccountDTO;
import com.coinnet.dto.ChatAccountDTO;
import com.coinnet.dto.ChatDTO;
import com.coinnet.dto.CustomerDTO;
import com.coinnet.entity.Account;
import com.coinnet.entity.Chat;
import com.coinnet.entity.ChatAccount;
import com.coinnet.entity.Customer;
import com.coinnet.repository.RepositoryFactory;
import com.coinnet.repository.custom.ChatAccountRepository;
import com.coinnet.repository.custom.ChatRepository;
import com.coinnet.resource.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Vidurajith
 */
public class ChatBOImpl implements ChatBO{

    private ChatRepository chatRepository;
    private ChatAccountRepository chatAccountRepository;

    public ChatBOImpl() {
        
        chatAccountRepository=(ChatAccountRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.CHATACCOUNT);
        chatRepository=(ChatRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.CHAT);
    }
    
    
    
    @Override
    public boolean saveChat(ChatDTO chatDTO,ChatAccountDTO chatAccountDTO,CustomerDTO customerDTO,AccountDTO accountDTO) throws Exception {
        
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            chatRepository.setSession(session);
            chatAccountRepository.setSession(session);
            
            boolean result=false;
            
            Chat chat=new Chat(chatDTO.getDescription(),chatDTO.getTime());
            Account account=new Account(chatAccountDTO.getSendAid(),new Customer(customerDTO.getCid(),customerDTO.getName(),customerDTO.getAddress(),customerDTO.getPic(),customerDTO.getBirthday(),customerDTO.getContact()),accountDTO.getEmail(),accountDTO.getPassword(),accountDTO.getPayment());
            
            if(chatRepository.save(chat)){
                if(chatAccountRepository.save(new ChatAccount(chat, account,chatAccountDTO.getReceiveAid()))){
                    session.getTransaction().commit();
                    session.close();
                    result=true;
                }
            }
            if(!result){
                session.getTransaction().rollback();
                session.close();
            }
            return result;
            
        }
    }

    @Override
    public List<ChatDTO> getAllChat() throws Exception {
        
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            
            chatRepository.setSession(session);
            List<ChatDTO> chatList=new ArrayList<>();
        
            List<Chat> list=chatRepository.getAll();
            if(list!=null){
                for (Chat chat : list) {
                    ChatDTO chatDto=new ChatDTO(chat.getChatId(),chat.getDescription(),chat.getTime());
                    chatList.add(chatDto);
                }
            }
            session.close();
            return chatList;
            
        }
        
    }
    
}
