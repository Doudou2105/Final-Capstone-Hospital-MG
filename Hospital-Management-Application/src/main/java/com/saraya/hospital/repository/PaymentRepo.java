package com.saraya.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saraya.hospital.model.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long> {
    
}