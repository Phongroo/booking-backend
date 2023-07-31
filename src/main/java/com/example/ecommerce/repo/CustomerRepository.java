package com.example.ecommerce.repo;

import com.example.ecommerce.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customers,Long> {
    Customers getCustomersByPhoneNumber(String phoneNumber);
}
