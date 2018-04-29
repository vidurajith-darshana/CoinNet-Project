/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.business.custom.impl;

import com.coinnet.business.custom.TicketBO;
import com.coinnet.dto.AdminDTO;
import com.coinnet.dto.TicketDTO;
import com.coinnet.entity.Admin;
import com.coinnet.entity.Ticket;
import com.coinnet.repository.RepositoryFactory;
import com.coinnet.repository.custom.TicketRepository;
import com.coinnet.resource.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Vidurajith
 */
public class TicketBOImpl implements TicketBO{

    private TicketRepository ticketRepository;

    public TicketBOImpl() {
        
        ticketRepository=(TicketRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.TICKET);
    }
    
    
    
    @Override
    public boolean saveTicket(TicketDTO ticketDTO,AdminDTO adminDTO) throws Exception {
        
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            ticketRepository.setSession(session);
            Ticket ticket=new Ticket(new Admin(adminDTO.getAdminID(),adminDTO.getName(),adminDTO.getPic(),adminDTO.getAddress(),adminDTO.getContact(),adminDTO.getEmail(),adminDTO.getPassword(),adminDTO.getReal_payment()), ticketDTO.getName(),ticketDTO.getPrice(),ticketDTO.getPic());
            if(ticketRepository.save(ticket)){
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
    public List<TicketDTO> getAll() throws Exception {
        
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            ticketRepository.setSession(session);
            List<Ticket> tickets=ticketRepository.getAll();
            List<TicketDTO> ticktList=new ArrayList<>();
            for (Ticket ticket : tickets) {
                ticktList.add(new TicketDTO(ticket.getTicketId(),ticket.getAdmin().getAdminId(),ticket.getName(),ticket.getPrice(),ticket.getPic()));
            }
            session.close();
            return ticktList;
        }
    }
    
}
