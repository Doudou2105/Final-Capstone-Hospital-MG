package com.saraya.hospital.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saraya.hospital.model.Receptionist;

@Repository
public interface ReceptionistRepo extends JpaRepository<Receptionist, Long> {

    Receptionist findByEmail(String email);
    Receptionist findByEmailAndPassword(String email, String password);
}