package com.saraya.hospital.model;


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
public class Admin {
        
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long admin_id;
    private String email;
    private String  password;

    @OneToMany(targetEntity = Patient.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="p_kp",referencedColumnName = "admin_id")
    private List<Patient> patients;

    @OneToMany(targetEntity = Appointment.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="a_kp",referencedColumnName = "admin_id")
    private List<Appointment> appointments;

    @OneToMany(targetEntity = Doctor.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="d_kp",referencedColumnName = "admin_id")
    private List<Doctor> doctors;

    @OneToMany(targetEntity = Receptionist.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="r_kp",referencedColumnName = "admin_id")
    private List<Receptionist> receptionists;


    
  

}
