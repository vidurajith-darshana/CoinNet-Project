/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.service.custom;

import com.coinnet.dto.AdminDTO;
import com.coinnet.dto.TicketDTO;
import com.coinnet.service.SuperService;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public interface TicketService extends SuperService{
    
    public boolean saveTicket(TicketDTO ticketDTO,AdminDTO adminDTO)throws Exception;
    
    public boolean saveImage(byte[] image, String name) throws Exception;
 
    public byte[] getImage(String email) throws Exception;
    
    public List<TicketDTO> getAll()throws Exception;
}
