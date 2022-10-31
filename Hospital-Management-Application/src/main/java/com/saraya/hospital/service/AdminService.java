package com.saraya.hospital.service;

import org.springframework.stereotype.Service;

import com.saraya.hospital.model.Admin;
import com.saraya.hospital.repository.AdminRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminService {
private final AdminRepo adminRepo;

public Admin getAdminByEmail(String email){
    return adminRepo.findByEmail(email);
}

public Admin getAdminByEmailAndPassword(String email, String password){
    return adminRepo.findByEmailAndPassword(email, password);
}
}