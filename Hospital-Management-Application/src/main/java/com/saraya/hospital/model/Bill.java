package com.saraya.hospital.model;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Bill {

     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long bill_id;
    private String patient_Name;
    private int age;
    private String hospital_No;
    private String bed_No;
    private LocalDate admission;
    private LocalDate discharge;
    private double amount;
}