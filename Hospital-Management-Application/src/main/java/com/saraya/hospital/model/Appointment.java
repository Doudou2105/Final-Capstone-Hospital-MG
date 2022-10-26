package com.saraya.hospital.model;



import java.time.LocalDate;
import java.time.LocalTime;



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

public class Appointment  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
               private Long appointment_id;
               private  LocalTime createAt = LocalTime.now();
               private LocalDate dateOfAppointment;
               private LocalTime appointmentStarTime;
               private LocalTime appointmentEndTime;
               private String medical_issues;
                private String firstName;
                private String lastName;
                private String email;
                private String doctorName;
                private String photograph;
                private String blood;
                private String gender;
                private Boolean  status = false;

               @ManyToOne
               private Patient patient;
               @ManyToOne
               private Receptionist receptionist;
              
             
           
}