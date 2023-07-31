package com.example.ecommerce.repo;

import com.example.ecommerce.model.Tickets;
import com.example.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface TicketRepository extends JpaRepository<Tickets,Long> {
    List<Tickets>findByUserTicket(User user);

    @Query(value = "select * from tickets t, customers c where t.customers_id=c.id and t.status='complete' and c.phone_number =:phoneNumber",nativeQuery = true)
    List<Tickets> ticketByPhone(String phoneNumber);

    @Query(value = "SELECT SUM(s.support_count) FROM support_status s, users u " +
            "WHERE s.date >= :startTime AND s.date <= :endTime AND s.gdv_id = u.id AND u.username = :username", nativeQuery = true)
    Integer statistical(@Param("startTime") LocalDate startTime, @Param("endTime") LocalDate endTime, @Param("username") String username);
}
