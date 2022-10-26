package com.saraya.hospital.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saraya.hospital.model.Bill;
import com.saraya.hospital.repository.BillRepo;


import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping("/api/v7/bill")
@RequiredArgsConstructor
public class BillController {
    
    private final BillRepo billRepo;

    @GetMapping("/allBills")
    @ResponseStatus(HttpStatus.OK)
    public List <Bill> getBills() {
        return billRepo.findAll();
    }
    
    @DeleteMapping("/deleteBill/{bill_id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBill(@PathVariable final Long bill_id){
        billRepo.deleteById(bill_id);
    }

}