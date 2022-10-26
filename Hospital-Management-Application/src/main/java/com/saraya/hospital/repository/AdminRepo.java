package com.saraya.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saraya.hospital.model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long>{
    
}