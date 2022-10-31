package com.saraya.hospital.service;

import org.springframework.stereotype.Service;

import com.saraya.hospital.model.Doctor;
import com.saraya.hospital.repository.DoctorRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepo doctorRepo;

    public Doctor getDoctorByEmail(String email){
        return doctorRepo.findByEmail(email);
    }

    public Doctor getDoctorByEmailAndPassword(String email, String password){
        return doctorRepo.findByEmailAndPassword(email, password);
    }
    
}