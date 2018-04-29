/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.business.custom;

import com.coinnet.business.SuperBO;
import com.coinnet.dto.AdminDTO;
import com.coinnet.dto.TicketDTO;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public interface TicketBO extends SuperBO{
    
    public boolean saveTicket(TicketDTO ticketDTO,AdminDTO adminDTO)throws Exception;
    
    public List<TicketDTO> getAll()throws Exception;
    
}
