package com.saraya.hospital.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



import com.saraya.hospital.exception.ResourceNotFoundException;
import com.saraya.hospital.model.Patient;

import com.saraya.hospital.repository.PatientRepo;


import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/patient")
public class PatientController {

    private final PatientRepo patientRepo;
   

      @PostMapping("/addPatient")
      @ResponseStatus(HttpStatus.CREATED)
      public Patient addPatient(@RequestBody final Patient patient){
        return patientRepo.save(patient);
      }

      @GetMapping("/allPatients")
      @ResponseStatus(HttpStatus.OK)
      public List <Patient> getAllPatients(){
        return patientRepo.findAll();
      }

    @PutMapping("/updatePatient/{patient_id}")
    @ResponseStatus(HttpStatus.OK)
    public Patient updatePatient(@PathVariable final Long patient_id, @RequestBody final Patient patientDetails){
        Patient patient = patientRepo.findById(patient_id).
				orElseThrow(() -> new ResourceNotFoundException("Patient : " + patient_id +" "+"doesn't exist"));

                patient.setFirstName(patientDetails.getFirstName());
                patient.setLastName(patientDetails.getLastName());
                patient.setEmail(patientDetails.getEmail());
                patient.setAddress(patientDetails.getAddress());
                patient.setPassword(patientDetails.getPassword());
                patient.setNumber(patientDetails.getNumber());
                patient.setPhotograph(patientDetails.getPhotograph());
                patient.setBlood(patientDetails.getBlood());
                patient.setAge(patientDetails.getAge());
                patient.setGender(patientDetails.getGender());

                return patientRepo.save(patient);

    }
    
   
    @GetMapping("/findPatient/{patient_id}")
    @ResponseStatus(HttpStatus.OK)
    public Patient getPatient(@PathVariable final Long patient_id){
        return patientRepo.findById(patient_id).
        orElseThrow(() -> new ResourceNotFoundException("Patient : " + patient_id +" "+"doesn't exist"));
    }
           

        
    }
    
