/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.service.custom.impl;

import com.coinnet.business.BOFactory;
import com.coinnet.business.custom.PublishTicketBO;
import com.coinnet.dto.AdminDTO;
import com.coinnet.dto.PublishTicketDTO;
import com.coinnet.dto.TicketDTO;
import com.coinnet.service.custom.PublishTicketService;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public class PublishTicketServiceImpl extends UnicastRemoteObject implements PublishTicketService{

    private PublishTicketBO publishTicketBO;
    
    public PublishTicketServiceImpl()throws Exception{
        publishTicketBO=(PublishTicketBO) BOFactory.getInstance().getBOTypes(BOFactory.BOTypes.PUBLISHTICKET);
    }
    
    @Override
    public boolean savePublishTicket(List<PublishTicketDTO> tickets, TicketDTO ticketDTO, AdminDTO adminDTO) throws Exception {
        
        return publishTicketBO.savePublishTicket(tickets, ticketDTO, adminDTO);
    }

    @Override
    public List<PublishTicketDTO> getAll() throws Exception {
        
        return publishTicketBO.getAll();
    }

    @Override
    public int getNewTerm(int ticketId) throws Exception {
        System.out.println(ticketId);
        return publishTicketBO.getNewTerm(ticketId);
    }
    
}
