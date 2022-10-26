package com.saraya.hospital.model;




import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import javax.persistence.CascadeType;
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


public class Doctor  {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

              private Long doctor_id;
              private String fullName;
              private String  email;
              private String  password;
              private String  gender;
              private String  number;
              private String  qualification;
              private int  age;
              private String  photograph;
              private String  address;
              private double salary;
              private String  month;
              private String  year;
              private String attendance;
               @OneToMany(targetEntity = Patient.class,cascade = CascadeType.ALL)
               @JoinColumn(name ="pat_kp",referencedColumnName = "doctor_id")
                private List<Patient> patients;

                @OneToMany(targetEntity = Bill.class,cascade = CascadeType.ALL)
                @JoinColumn(name ="b_kp",referencedColumnName = "doctor_id")
                 private List<Bill> bills;
            
              
          
}