/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.business.custom;

import com.coinnet.business.SuperBO;
import com.coinnet.dto.AdminDTO;
import com.coinnet.dto.PublishTicketDTO;
import com.coinnet.dto.TicketDTO;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public interface PublishTicketBO extends SuperBO{
    
    public boolean savePublishTicket(List<PublishTicketDTO> tickets,TicketDTO ticketDTO,AdminDTO adminDTO)throws Exception;
    
    public List<PublishTicketDTO> getAll()throws Exception;
    
    public int getNewTerm(int ticketId)throws Exception;
}
