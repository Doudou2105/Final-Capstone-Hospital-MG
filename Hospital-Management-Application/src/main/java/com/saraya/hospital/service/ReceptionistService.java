package com.saraya.hospital.service;

import org.springframework.stereotype.Service;

import com.saraya.hospital.model.Receptionist;
import com.saraya.hospital.repository.ReceptionistRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReceptionistService {

    private final ReceptionistRepo receptionistRepo;

    public Receptionist getReceptionistByEmail(String email){
        return receptionistRepo.findByEmail(email);
    }

    public Receptionist getReceptionistByEmailAndPassword(String email, String password){
        return receptionistRepo.findByEmailAndPassword(email, password);
    }
    
}