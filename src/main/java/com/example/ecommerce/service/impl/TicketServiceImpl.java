package com.example.ecommerce.service.impl;

import com.example.ecommerce.config.JwtAuthenticationFilter;
import com.example.ecommerce.model.*;
import com.example.ecommerce.repo.*;
import com.example.ecommerce.service.TicketService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketRepository repo;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    SupportStatusRepository supportStatusRepository;
    @Autowired
    NumericalOrderRepository numericalOrderRepository;
    @Override
    public BaseResponse addTicket(TicketRequest ticketRequest, Long productId) {
        Customers customers= customerRepository.getCustomersByPhoneNumber(ticketRequest.getCustomers().getPhoneNumber());
        User user=userRepository.user(productId);
        Products products=productRepository.findById(productId).get();
        Tickets tickets = new Tickets();
        LocalDate currentDate = LocalDate.now();
        NumericalOrder numeri=new NumericalOrder();
        long stt= 0;
        if(customers==null){
            Customers customers1=customerRepository.save(ticketRequest.getCustomers());
            tickets=new Tickets("hàng đợi",stt+1,customers1,user,products);

        }
        else {
            if(customers.isPriorty()==true) {
                tickets = new Tickets("ưu tiên", 1, customers, user, products);
            }
            else {
                tickets = new Tickets("hàng đợi", 1, customers, user, products);
            }
        }
        Tickets create = repo.save(tickets);

        if (create != null ) {
            user.setNum(user.getNum()-1);
            this.userRepository.save(user);
            NumericalOrder numericalOrder = numericalOrderRepository.getNumericalOrderByDateAndStatus(currentDate,create.getStatus());
            if(numericalOrder!=null){
                numericalOrder.setNum(numericalOrder.getNum()+1);
               numeri=  this.numericalOrderRepository.save(numericalOrder);
            }
            else {
                NumericalOrder numericalOrder1=new NumericalOrder(currentDate,create.getStatus(),1);
                numeri= this.numericalOrderRepository.save(numericalOrder1);
            }

            return new BaseResponse(numericalOrder, String.valueOf(HttpStatus.OK.value()), "Tạo mới thành công");

        }

        return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Tạo mới thất bại");
    }

    @Override
    public BaseResponse updateTicket(Tickets tickets) {
        return null;
    }

    @Override
    public BaseResponse getTicket(Long ticketId) {
        return null;
    }

    @Override
    public BaseResponse deleteTicket(Tickets tickets) {
        this.repo.deleteById(tickets.getId());
        return new BaseResponse(tickets, String.valueOf(HttpStatus.OK.value()), "Xoá thành công");

    }

    @Override
    public List<Tickets> list() {
        return repo.findAll();
    }

    @Override
    public List<Tickets> getTickByUser() {
        String username= JwtAuthenticationFilter.CURRENT_USER;
       User user= userRepository.findByUsername(username);
        return repo.findByUserTicket(user);
    }

    @Override
    public BaseResponse updateStatus(Long ticketId) {
        String username= JwtAuthenticationFilter.CURRENT_USER;
        User user= userRepository.findByUsername(username);
        LocalDate currentDate = LocalDate.now();
        LocalDateTime localDateTime=LocalDateTime.now();
        Tickets tickets=repo.findById(ticketId).get();
        if (tickets!=null){
            tickets.setStatus("complete");
            tickets.setEndTime(localDateTime);
            Tickets tickets1=this.repo.save(tickets);
            if(tickets1!=null){
                Support_Status supportStatus= supportStatusRepository.getSupport_StatusByDateAndUserSupport(currentDate,user);
                if(supportStatus!=null){
                    supportStatus.setSupportCount(supportStatus.getSupportCount()+1);
                    this.supportStatusRepository.save(supportStatus);
                }
                else {
                    Support_Status supportStatus1=new Support_Status(currentDate,1,user);
                    this.supportStatusRepository.save(supportStatus1);
                }
                return new BaseResponse(tickets1, String.valueOf(HttpStatus.OK.value()), "Update thành công");
            }


        }

        return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Update thất bại");
    }

    @Override
    public List<Tickets> ticketByPhone(String phoneNumber) {
        return this.repo.ticketByPhone(phoneNumber);

    }

    @Override
    public BaseResponse updatRating(Long ticketId, Integer rating) {
        Tickets tickets=repo.findById(ticketId).get();
        tickets.setRating(rating);
        tickets.setStatus("end");
        return new BaseResponse(this.repo.save(tickets), String.valueOf(HttpStatus.OK.value()), "Update thành công");
    }

    @Override
    public BaseResponse getStatistical(statisticalRequest request) {
        String username= JwtAuthenticationFilter.CURRENT_USER;
        Integer num=this.repo.statistical(request.getStartTime(),request.getEndTime(),username);
        return new BaseResponse(num, String.valueOf(HttpStatus.OK.value()), "cc thành công");
    }
}
