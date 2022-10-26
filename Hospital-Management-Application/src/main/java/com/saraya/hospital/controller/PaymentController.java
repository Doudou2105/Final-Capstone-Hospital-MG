package com.saraya.hospital.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.saraya.hospital.exception.ResourceNotFoundException;
import com.saraya.hospital.model.Payment;
import com.saraya.hospital.repository.PaymentRepo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v4/payment")
public class PaymentController {
    
    private final PaymentRepo paymentRepo;


    @PostMapping("/addPayment")
    @ResponseStatus(HttpStatus.CREATED)
    public Payment addPayment(@RequestBody final Payment payment){
        return paymentRepo.save(payment);
    }

    @GetMapping("/allPayment")
    @ResponseStatus(HttpStatus.OK)
    public List <Payment> getPayments(){
        return paymentRepo.findAll();
    }

    @GetMapping("/findPayment/{payment_id}")
    @ResponseStatus(HttpStatus.OK)
    public Payment getPaymentById(@PathVariable final Long payment_id){
        return paymentRepo.findById(payment_id).
        orElseThrow(()-> new ResourceNotFoundException("Payment : " + payment_id +" "+"doesn't exist"));
    }
}