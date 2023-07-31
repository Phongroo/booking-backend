package com.example.ecommerce.controller;

import com.example.ecommerce.config.JwtAuthenticationFilter;
import com.example.ecommerce.model.BaseResponse;
import com.example.ecommerce.model.TicketRequest;
import com.example.ecommerce.model.Tickets;
import com.example.ecommerce.model.statisticalRequest;
import com.example.ecommerce.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    TicketService service;
    private final SimpMessagingTemplate messagingTemplate;

    public TicketController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @PostMapping(value = "/createTicket/{productId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createTicket(@RequestBody TicketRequest payload,@PathVariable("productId") Long productId) {
        return ResponseEntity.status(HttpStatus.OK).body(service.addTicket(payload,productId));
    }
    @DeleteMapping(value = "/delete")
    public ResponseEntity<BaseResponse> deleteProduct(@RequestBody Tickets payload) {
        Tickets a=payload;

        return ResponseEntity.status(HttpStatus.OK).body(service.deleteTicket(payload));
    }
    @GetMapping(value = "/")
    public ResponseEntity<?> tickets(){
        return ResponseEntity.ok(this.service.list());
    }

    @GetMapping(value = "/getTicketByUse")
    public ResponseEntity<?> getTicketByUser(){
        return ResponseEntity.ok(this.service.getTickByUser());
    }

    @PostMapping(value = "/update/{ticketId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> update(@PathVariable("ticketId") Long ticketId) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateStatus(ticketId));
    }

    @PostMapping(value = "/ticketByPhone/{phoneNumber}")
    public ResponseEntity<?> update(@PathVariable("phoneNumber") String phoneNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(service.ticketByPhone(phoneNumber));
    }

    @PostMapping(value = "/updateRating/{ticketId}/{rating}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateRating(@PathVariable("ticketId") Long ticketId, @PathVariable("rating")Integer rating) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updatRating(ticketId,rating));
    }

    @PostMapping(value = "/getStatistical")
    public ResponseEntity<BaseResponse> getStatistical(@RequestBody statisticalRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(service.getStatistical(request));

    }
}
