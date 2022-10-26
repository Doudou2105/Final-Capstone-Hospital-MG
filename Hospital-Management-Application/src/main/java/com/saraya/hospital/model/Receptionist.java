package com.saraya.hospital.model;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

public class Receptionist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
               private Long receptionist_id;
               private String name;
               private String email;
               private String password;
               private String photogroph;
               private String address;
               private LocalDate birthday;
               private String number;
               private String gender;

               @OneToMany(targetEntity = Appointment.class,cascade = CascadeType.ALL)
               @JoinColumn(name ="a_kp",referencedColumnName = "receptionist_id")
               private List<Appointment> appointments;

               @OneToMany(targetEntity = Patient.class,cascade = CascadeType.ALL)
               @JoinColumn(name ="p_kp",referencedColumnName = "receptionist_id")
               private List<Patient> patients;

               
             
           
}