/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.business.custom.impl;

import com.coinnet.business.custom.DrawTicketBO;
import com.coinnet.dto.DrawTicketDTO;
import com.coinnet.entity.DrawTicket;
import com.coinnet.repository.RepositoryFactory;
import com.coinnet.repository.custom.DrawTicketRepository;
import com.coinnet.resource.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Vidurajith
 */
public class DrawTicketBoImpl implements DrawTicketBO{

    private DrawTicketRepository drawTicketRepository;
    
    public DrawTicketBoImpl() {
        drawTicketRepository=(DrawTicketRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.DRAWTICKET);
    }

    
    
    @Override
    public List<DrawTicketDTO> getAll() throws Exception {
        
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            drawTicketRepository.setSession(session);
            List<DrawTicket> draws=drawTicketRepository.getAll();
            List<DrawTicketDTO> tickets=new ArrayList<>();
            
            for (DrawTicket draw : draws) {
                tickets.add(new DrawTicketDTO(draw.getDrawId(),draw.getPublishTicket().getPublishId(),draw.getWonPrice()));
            }
            session.close();
            return tickets;
        }
        
    }
    
}
