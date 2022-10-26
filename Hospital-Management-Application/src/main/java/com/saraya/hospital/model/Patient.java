package com.saraya.hospital.model;





import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Patient  {
    
        
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
           private Long patient_id;
           private String firstName;
           private String lastName;
           private String email;
           private String address;
           private String password;
           private String number;
           private String photograph;
           private String blood;         
           private int age;
           private String gender;
           @ManyToOne
           private Receptionist receptionist;

           @ManyToOne
           private Doctor doctor;
           
           @OneToMany(targetEntity = Bill.class,cascade = CascadeType.ALL)
           @JoinColumn(name ="b_kp",referencedColumnName = "patient_id")
           private List<Bill> bills;
       
            @OneToMany(targetEntity = Appointment.class,cascade = CascadeType.ALL)
            @JoinColumn(name ="a_kp",referencedColumnName = "patient_id")
            private List<Appointment> appointments;
                
  
        
}