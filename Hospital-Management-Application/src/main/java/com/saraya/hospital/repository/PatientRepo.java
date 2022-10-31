package com.saraya.hospital.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.saraya.hospital.model.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {

  Patient findByEmail(String email);
  Patient findByEmailAndPassword(String email, String password);
  }                                                   
                                                                                                                                                                                                    
                                                                                                                                                                                        
                                                                                                                                                                                        
                                                                                                                                                                                        
                                                                                                                                                                                        
                                                                                                                                                                                                                            
                                                                        
                                                                        
                                                                        
                                                                       
                                                                        