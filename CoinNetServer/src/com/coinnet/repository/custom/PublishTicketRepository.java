/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.repository.custom;

import com.coinnet.entity.PublishTicket;
import com.coinnet.repository.SuperRepository;

/**
 *
 * @author Vidurajith
 */
public interface PublishTicketRepository extends SuperRepository<PublishTicket,Integer>{
    
    public int getNewTerm(int ticketId)throws Exception;
    
}
