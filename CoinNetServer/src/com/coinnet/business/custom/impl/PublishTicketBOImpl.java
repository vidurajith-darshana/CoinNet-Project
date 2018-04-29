/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.business.custom.impl;

import com.coinnet.business.custom.PublishTicketBO;
import com.coinnet.dto.AdminDTO;
import com.coinnet.dto.PublishTicketDTO;
import com.coinnet.dto.TicketDTO;
import com.coinnet.entity.Admin;
import com.coinnet.entity.PublishTicket;
import com.coinnet.entity.Ticket;
import com.coinnet.repository.RepositoryFactory;
import com.coinnet.repository.custom.PublishTicketRepository;
import com.coinnet.resource.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Vidurajith
 */
public class PublishTicketBOImpl implements PublishTicketBO{

    private PublishTicketRepository publishTicketRepository;

    public PublishTicketBOImpl() {
        publishTicketRepository=(PublishTicketRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.PUBLISHTICKET);
    }
    
    
    
    @Override
    public boolean savePublishTicket(List<PublishTicketDTO> tickets, TicketDTO ticketDTO,AdminDTO adminDTO) throws Exception {
        
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            publishTicketRepository.setSession(session);
            int count=0;
            for(int i=0;i<tickets.size();i++){
                if(publishTicketRepository.save(new PublishTicket(new Ticket(ticketDTO.getTicketId(), new Admin(adminDTO.getAdminID(),adminDTO.getName(),adminDTO.getPic(),adminDTO.getAddress(),adminDTO.getContact(),adminDTO.getEmail(),adminDTO.getPassword(),adminDTO.getReal_payment()),ticketDTO.getName(), ticketDTO.getPrice(), ticketDTO.getPic()), tickets.get(i).getNumbers(),tickets.get(i).getTerm(),tickets.get(i).getDate(),tickets.get(i).getGiftPrice()))){
                    count++;
                    session.flush();
                    session.clear();
                }
            }
            if(tickets.size()==count){
                session.getTransaction().commit();
                session.close();
                return true;
            }
            
            session.getTransaction().rollback();
            session.close();
            return false;
        }
    }

    @Override
    public List<PublishTicketDTO> getAll() throws Exception {
        
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            publishTicketRepository.setSession(session);
            List<PublishTicket> tickets=publishTicketRepository.getAll();
            List<PublishTicketDTO> ticketList=new ArrayList<>();
            for (PublishTicket ticket : tickets) {
                ticketList.add(new PublishTicketDTO(ticket.getPublishId(),ticket.getTicket().getTicketId(),ticket.getNumbers(),ticket.getTerm(),ticket.getDates(), ticket.getGiftPrice()));
            }
            session.close();
            return ticketList;
        }
    }

    @Override
    public int getNewTerm(int ticketId) throws Exception {
        
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            publishTicketRepository.setSession(session);
            int term= publishTicketRepository.getNewTerm(ticketId);
            session.close();
            return term;
        }
    }
    
}
