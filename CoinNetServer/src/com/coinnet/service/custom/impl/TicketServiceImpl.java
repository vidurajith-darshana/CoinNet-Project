/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.service.custom.impl;

import com.coinnet.business.BOFactory;
import com.coinnet.business.custom.TicketBO;
import com.coinnet.dto.AdminDTO;
import com.coinnet.dto.TicketDTO;
import com.coinnet.service.custom.TicketService;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author Vidurajith
 */
public class TicketServiceImpl extends UnicastRemoteObject implements TicketService{
    
    private TicketBO ticketBO;
    
    public TicketServiceImpl()throws RemoteException{
        ticketBO=(TicketBO) BOFactory.getInstance().getBOTypes(BOFactory.BOTypes.TICKET);
    }

    @Override
    public boolean saveTicket(TicketDTO ticketDTO,AdminDTO adminDTO) throws Exception {
        
        return ticketBO.saveTicket(ticketDTO, adminDTO);
    }
    
    @Override
    public boolean saveImage(byte[] image, String name) throws Exception {
        
        try{
            BufferedImage buf=ImageIO.read(new ByteArrayInputStream(image));
            ImageIO.write(buf, "png",new File("ticket/"+name+".png"));
            return true;
        }catch(Exception ex){
            return false;
        }
        
    }

    @Override
    public byte[] getImage(String ticket) throws Exception {
        
        try {
      
            File serverPathFile = new File("ticket/" + ticket+".png");
            byte[] mydata = new byte[(int) serverPathFile.length()];
   
            FileInputStream in = new FileInputStream(serverPathFile);
            in.read(mydata, 0, mydata.length);
            in.close();
            return mydata;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }     
    }

    @Override
    public List<TicketDTO> getAll() throws Exception {
        
        return ticketBO.getAll();
    }
    
}
