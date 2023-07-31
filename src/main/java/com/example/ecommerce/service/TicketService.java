package com.example.ecommerce.service;

import com.example.ecommerce.model.*;


import java.util.List;


public interface TicketService {
    BaseResponse addTicket(TicketRequest ticketRequest,Long productId);
    BaseResponse updateTicket(Tickets tickets);
    BaseResponse getTicket(Long ticketId);
    BaseResponse deleteTicket(Tickets tickets);
    public List<Tickets> list();
    public List<Tickets> getTickByUser();
    public BaseResponse updateStatus(Long ticketId);
    public List<Tickets> ticketByPhone(String phoneNumber);
    BaseResponse updatRating(Long ticketId,Integer rating);
    BaseResponse getStatistical(statisticalRequest request);

}
