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
import com.saraya.hospital.model.Appointment;
import com.saraya.hospital.repository.AppointmentRepo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v2/appointment")
public class AppointmentController {

    private final AppointmentRepo appointmentRepo;

    @PostMapping("/addAppointment")
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment addAppointment( @RequestBody final Appointment appointment){
        return appointmentRepo.save(appointment);

    }

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
    public void deleteAppointment(@PathVariable final Long apppointment_id){
        appointmentRepo.deleteById(apppointment_id);
    }


    @PutMapping("/updateAppointment/{appointment_id}")
    @ResponseStatus(HttpStatus.OK)
    public Appointment updateAppointment(@PathVariable final Long appointment_id, @RequestBody final Appointment appointmentDetails){
        Appointment appointment = appointmentRepo.findById(appointment_id).
				orElseThrow(() -> new ResourceNotFoundException("Appointment : " + appointment_id +" "+"doesn't exist"));

                appointment.setStatus(appointmentDetails.getStatus());
                appointment.setEmail(appointmentDetails.getEmail());
               

                return appointmentRepo.save(appointment);

    }
    
}