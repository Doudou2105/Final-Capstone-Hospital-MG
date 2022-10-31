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
import com.saraya.hospital.model.Doctor;

import com.saraya.hospital.repository.DoctorRepo;
import com.saraya.hospital.service.DoctorService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v3/doctor")
public class DoctorController {
    
    private final DoctorRepo doctorRepo;
    private final DoctorService doctorService;
   
    //Register
    @PostMapping("/addDoctor")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor addDoctor(@RequestBody final Doctor doctor) throws Exception{
            String myEmail = doctor.getEmail();
            if(myEmail != null && !"".equals(myEmail)){
              Doctor doctorObj = doctorService.getDoctorByEmail(myEmail);
              if(doctorObj != null){
                throw new Exception("Doctor with"+" "+ myEmail+" "+"Already exsit");
              }
            }

        return doctorRepo.save(doctor);
    }

      // Sign the Doctor
      @PostMapping("/loginDoctor")
      @ResponseStatus(HttpStatus.CREATED)
      public Doctor loginDoctor(@RequestBody final Doctor doctor) throws Exception{
        String myEmail = doctor.getEmail();
        String myPassword = doctor.getPassword();
        Doctor doctorObj = null;
        if(myEmail != null && myPassword != null){
          doctorObj = doctorService.getDoctorByEmailAndPassword(myEmail, myPassword);
        }if(doctorObj == null){
          throw new Exception("Bad Request Try again");
        }
        return doctorObj;
      }


    
    @GetMapping("/allDoctors")
    @ResponseStatus(HttpStatus.OK)
    public List <Doctor> getDoctors(){
        return doctorRepo.findAll();
    }

    @PutMapping("/updateDoctor/{doctor_id}")
    @ResponseStatus(HttpStatus.OK)
    public Doctor updateDoctor(@PathVariable final Long doctor_id, @RequestBody final Doctor doctorDetails){
        Doctor doctor = doctorRepo.findById(doctor_id).
				orElseThrow(() -> new ResourceNotFoundException("Doctor : " + doctor_id +" "+"doesn't exist"));

                        doctor.setFullName(doctorDetails.getFullName());
                       doctor. setEmail(doctorDetails.getEmail());
                       doctor. setPassword(doctorDetails.getPassword());
                        doctor.setGender(doctorDetails.getGender());
                        doctor.setNumber(doctorDetails.getNumber());
                        doctor.setQualification(doctorDetails.getQualification());
                        doctor.setAge(doctorDetails.getAge());
                       doctor. setPhotograph(doctorDetails.getPhotograph());
                       doctor. setAddress(doctorDetails.getAddress());
                        doctor.setSalary(doctorDetails.getSalary());
                        doctor.setMonth(doctorDetails.getMonth());
                       doctor. setYear(doctorDetails.getYear());
                       doctor. setAttendance(doctorDetails.getAttendance());
		
                return doctorRepo.save(doctor);

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
		 doctorRepo.deleteById(doctor_id);
		
	}

}