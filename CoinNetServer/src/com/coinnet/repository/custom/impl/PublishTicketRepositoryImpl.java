/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.repository.custom.impl;

import com.coinnet.entity.PublishTicket;
import com.coinnet.repository.SuperRepositoryImpl;
import com.coinnet.repository.custom.PublishTicketRepository;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Vidurajith
 */
public class PublishTicketRepositoryImpl extends SuperRepositoryImpl<PublishTicket,Integer> implements PublishTicketRepository{

    @Override
    public int getNewTerm(int ticketId) throws Exception {
        
        Query query=session.createQuery("From PublishTicket where publishId=:ticketId");
        query.setParameter("ticketId", ticketId);
        List<PublishTicket> tickets=query.list();
        if(tickets.isEmpty()){
            return 1;
        }else{
            int term=0;
            for (PublishTicket ticket : tickets) {
                term=ticket.getTerm();
            }
            return term;
        }   
    }
    
}
