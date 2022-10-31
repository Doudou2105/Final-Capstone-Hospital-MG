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
import com.saraya.hospital.model.Receptionist;
import com.saraya.hospital.repository.ReceptionistRepo;
import com.saraya.hospital.service.ReceptionistService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v5/receptionist")
public class ReceptionistController {
    
    private final ReceptionistRepo receptionistRepo;
    private final ReceptionistService receptionistService;

    // Register

    @PostMapping("/addReceptionist")
    @ResponseStatus(HttpStatus.CREATED)
    public Receptionist addReceptionist(@RequestBody final Receptionist receptionist) throws Exception{

        String myEmail = receptionist.getEmail();
            if(myEmail != null && !"".equals(myEmail)){
              Receptionist receptionistObj = receptionistService.getReceptionistByEmail(myEmail);
              if(receptionistObj != null){
                throw new Exception("Receptionist with"+" "+ myEmail+" "+"Already exsit");
              }
            }
        return receptionistRepo.save(receptionist);
    }

      // Sign the Doctor
      @PostMapping("/loginReceptionist")
      @ResponseStatus(HttpStatus.CREATED)
      public Receptionist loginReceptionist(@RequestBody final Receptionist receptionist) throws Exception{
        String myEmail = receptionist.getEmail();
        String myPassword = receptionist.getPassword();
        Receptionist receptionistObj = null;
        if(myEmail != null && myPassword != null){
          receptionistObj = receptionistService.getReceptionistByEmailAndPassword(myEmail, myPassword);
        }if(receptionistObj == null){
          throw new Exception("Bad Request Try again");
        }
        return receptionistObj;
      }


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

    @PutMapping("/update/{receptionist_id}")
    public Receptionist updateReceptionist(@PathVariable Long receptionist_id, @RequestBody Receptionist receptionistDetails) {
        Receptionist receptionist = receptionistRepo.findById(receptionist_id).
        orElseThrow(() -> new ResourceNotFoundException("Receptionist : " + receptionist_id +" "+"doesn't exist"));

                        receptionist.setEmail(receptionistDetails.getEmail());
                        receptionist.setPassword(receptionistDetails.getPassword());
                        receptionist.setPhotogroph(receptionistDetails.getPhotogroph());
                        receptionist.setAddress(receptionistDetails.getAddress());
                        receptionist.setBirthday(receptionistDetails.getBirthday());
                        receptionist.setNumber(receptionistDetails.getNumber());
                        receptionist.setGender(receptionistDetails.getGender());
        return receptionistRepo.save(receptionist);
    }

    @DeleteMapping("/deleteReceptionist/{receptionist_id}")
    @ResponseStatus(HttpStatus.OK)
	public void deleteReceptionist(@PathVariable Long receptionist_id ){
		 receptionistRepo.deleteById(receptionist_id);
		
	}

   

}