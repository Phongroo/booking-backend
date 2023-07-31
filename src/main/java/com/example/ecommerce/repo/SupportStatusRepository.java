package com.example.ecommerce.repo;

import com.example.ecommerce.model.Support_Status;
import com.example.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;

public interface SupportStatusRepository extends JpaRepository<Support_Status,Long> {
    Support_Status getSupport_StatusByDateAndUserSupport(LocalDate date, User user);
}
