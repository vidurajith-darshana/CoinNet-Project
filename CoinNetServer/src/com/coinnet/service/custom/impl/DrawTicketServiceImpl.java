/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.service.custom.impl;

import com.coinnet.business.BOFactory;
import com.coinnet.business.custom.DrawTicketBO;
import com.coinnet.dto.DrawTicketDTO;
import com.coinnet.service.custom.DrawTicketService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public class DrawTicketServiceImpl extends UnicastRemoteObject implements DrawTicketService{

    private DrawTicketBO drawTicketBO;
    
    public DrawTicketServiceImpl()throws RemoteException{
        drawTicketBO=(DrawTicketBO) BOFactory.getInstance().getBOTypes(BOFactory.BOTypes.DRAW);
    }
    
    @Override
    public List<DrawTicketDTO> getAll() throws Exception {
        return drawTicketBO.getAll();
        
    }
    
}
