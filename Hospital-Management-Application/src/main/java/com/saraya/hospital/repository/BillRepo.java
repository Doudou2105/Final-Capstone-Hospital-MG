package com.saraya.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saraya.hospital.model.Bill;

@Repository
public interface BillRepo extends JpaRepository <Bill, Long> {
    
}