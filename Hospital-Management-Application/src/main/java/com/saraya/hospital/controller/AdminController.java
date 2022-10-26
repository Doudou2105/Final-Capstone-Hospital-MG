package com.saraya.hospital.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.saraya.hospital.exception.ResourceNotFoundException;
import com.saraya.hospital.model.Admin;
import com.saraya.hospital.model.Appointment;
import com.saraya.hospital.model.Bill;
import com.saraya.hospital.model.Doctor;
import com.saraya.hospital.model.Patient;
import com.saraya.hospital.model.Receptionist;
import com.saraya.hospital.repository.AdminRepo;
import com.saraya.hospital.repository.AppointmentRepo;
import com.saraya.hospital.repository.BillRepo;
import com.saraya.hospital.repository.DoctorRepo;
import com.saraya.hospital.repository.PatientRepo;
import com.saraya.hospital.repository.ReceptionistRepo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v6/admin")
public class AdminController {

    private final AdminRepo adminRepo;
    private final PatientRepo patientRepo;
    private final ReceptionistRepo receptionistRepo;
    private final DoctorRepo doctorRepo;
    private final AppointmentRepo appointmentRepo;
    private final BillRepo billRepo;

    @PostMapping("/addFromAdmin")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin addFromAdmin(@RequestBody final Admin admin){
        return adminRepo.save(admin);
    }
    
    @GetMapping("/allFromAdmin")
    @ResponseStatus(HttpStatus.OK)
    public List <Admin> getAllFromAdmin(){
        return adminRepo.findAll();
    }

    /////////////////////////////////////////////////////////////



    @GetMapping("/allAppointments")
    @ResponseStatus(HttpStatus.OK)
    public List <Appointment> getAppointments(){
        return appointmentRepo.findAll();
    }

    @GetMapping("/findAppoinitment/{apppointment_id}")
    @ResponseStatus(HttpStatus.OK)
    public Appointment getAppointment(@PathVariable final Long apppointment_id){
        return appointmentRepo.findById(apppointment_id).
        orElseThrow(() -> new ResourceNotFoundException("Appointment : " + apppointment_id +" "+"doesn't exist"));

    }

    @DeleteMapping("/deleteAppointment/{apppointment_id}")
    @ResponseStatus(HttpStatus.OK)
	public void deleteAppointment(@PathVariable Long apppointment_id ){
		 receptionistRepo.deleteById(apppointment_id);
		
	}

    //****************************************** */
    @GetMapping("/allReceptionists")
    @ResponseStatus(HttpStatus.OK)
    public List <Receptionist> getReceptionists(){
        return receptionistRepo.findAll();
    }

    @GetMapping("/findReceptionist/{receptionist_id}")
    @ResponseStatus(HttpStatus.OK)
    public Receptionist getReceptionist(@PathVariable final Long receptionist_id){
        return receptionistRepo.findById(receptionist_id).
        orElseThrow(() -> new ResourceNotFoundException("Receptionist : " + receptionist_id +" "+"doesn't exist"));

    }

    @DeleteMapping("/deleteReceptionist/{receptionist_id}")
    @ResponseStatus(HttpStatus.OK)
	public void deleteEmployee(@PathVariable Long receptionist_id ){
		 receptionistRepo.deleteById(receptionist_id);
		
	}
    

    //**************************************** */

    @GetMapping("/allPatients")
      @ResponseStatus(HttpStatus.OK)
      public List <Patient> getAllPatients(){
        return patientRepo.findAll();
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
		 receptionistRepo.deleteById(patient_id);
		
	}

 //**************************************** */
     
    @GetMapping("/allDoctors")
    @ResponseStatus(HttpStatus.OK)
    public List <Doctor> getDoctors(){
        return doctorRepo.findAll();
    }
    
    @GetMapping("/findDoctor/{doctor_id}")
    @ResponseStatus(HttpStatus.OK)
    public Doctor getDoctor(@PathVariable final Long doctor_id){
        return doctorRepo.findById(doctor_id).
        orElseThrow(() -> new ResourceNotFoundException("Doctor : " + doctor_id +" "+"doesn't exist"));
    }

    @DeleteMapping("/deleteDoctor/{doctor_id}")
    @ResponseStatus(HttpStatus.OK)
	public void deleteDoctror(@PathVariable Long doctor_id ){
		 receptionistRepo.deleteById(doctor_id);
		
	}

    /************************************************************* */

    @GetMapping("/allBills")
    @ResponseStatus(HttpStatus.OK)
    public List <Bill> getBills() {
        return billRepo.findAll();
    }
    
    @DeleteMapping("/deleteBill/{bill_id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBill(@PathVariable final Long bill_id){
        billRepo.deleteById(bill_id);
    }
}