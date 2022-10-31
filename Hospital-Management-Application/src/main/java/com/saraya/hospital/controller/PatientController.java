package com.saraya.hospital.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.saraya.hospital.service.PatientService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/patient")
public class PatientController {

    private final PatientRepo patientRepo;
   private final PatientService patientService;


      // register 

      @PostMapping("/addPatient")
      @ResponseStatus(HttpStatus.CREATED)
      public Patient addPatient(@RequestBody final Patient patient) throws Exception{
        String myEmail = patient.getEmail();
        if(myEmail != null && !"".equals(myEmail)){
          Patient patientObj = patientService.getPatientByEmail(myEmail);
          if(patientObj != null){
            throw new Exception("Patient with"+" "+ myEmail+" "+"Already exsit");
          }
        }
       
        return patientRepo.save(patient);
      }

      // Sign the Patient
      @PostMapping("/loginPatient")
      @ResponseStatus(HttpStatus.CREATED)
      public Patient loginPatient(@RequestBody final Patient patient) throws Exception{
        String myEmail = patient.getEmail();
        String myPassword = patient.getPassword();
        Patient patientObj = null;
        if(myEmail != null && myPassword != null){
          patientObj = patientService.getPatientByEmailAndPassword(myEmail, myPassword);
        }if(patientObj == null){
          throw new Exception("Bad Request Try again");
        }
        return patientObj;
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
           

    @DeleteMapping("/deletePatient/{patient_id}")
    @ResponseStatus(HttpStatus.OK)
	public void deletePatient(@PathVariable Long patient_id ){
		 patientRepo.deleteById(patient_id);
		
	}

        
    }
    
