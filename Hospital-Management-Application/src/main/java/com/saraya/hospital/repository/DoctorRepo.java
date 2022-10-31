package com.saraya.hospital.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.saraya.hospital.model.Doctor;


@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {

    Doctor findByEmail(String email);
    Doctor findByEmailAndPassword(String email, String password);
    
}