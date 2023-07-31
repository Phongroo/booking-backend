package com.example.ecommerce.repo;

import com.example.ecommerce.model.NumericalOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface NumericalOrderRepository extends JpaRepository<NumericalOrder,Long> {
    NumericalOrder getNumericalOrderByDateAndStatus(LocalDate date,String status);
}
