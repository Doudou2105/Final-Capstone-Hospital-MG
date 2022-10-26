package com.saraya.hospital.model;


import java.time.LocalDate;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Payment {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
          private Long payment_id ;
          private String  cart_number;
          private String  country;
          private LocalDate  expiry;
          private String  zip;
          private String  cvc ; 
          @ManyToOne
          private Patient patient;
          
}