package com.saraya.hospital.service;

import org.springframework.stereotype.Service;

import com.saraya.hospital.model.Patient;
import com.saraya.hospital.repository.PatientRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepo patientRepo;

    public Patient getPatientByEmail(String email){
        return patientRepo.findByEmail(email);
    }

    public Patient getPatientByEmailAndPassword(String email, String password){
        return patientRepo.findByEmailAndPassword(email, password);
    }
    
}