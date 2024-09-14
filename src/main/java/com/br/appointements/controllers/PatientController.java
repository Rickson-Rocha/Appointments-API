package com.br.appointements.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.appointements.schemas.Patient;
import com.br.appointements.services.PatientService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("patients")
@RequiredArgsConstructor
public class PatientController {
     
    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<Patient> createPatient( @Valid @RequestBody Patient patient, UriComponentsBuilder uriBuilder){

       Patient newPatient = patientService.createPatient(patient);
       var uri = uriBuilder.path("/patients/{id}").buildAndExpand(newPatient.getId()).toUri();
       return ResponseEntity.created(uri).build();
    }
    
    @GetMapping
    public ResponseEntity<List<Patient>>fetchAll(){
        List<Patient> patients = patientService.fetchAll();;
        return ResponseEntity.status(HttpStatus.OK).body(patients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> findById(@PathVariable Long id){
        Patient patient = patientService.getById(id);
        return ResponseEntity.ok().body(patient);
    }

    
   
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        patientService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(
            @PathVariable Long id, 
            @RequestBody @Valid Patient patientDetails) {

        
         patientService.update(id, patientDetails);

        return ResponseEntity.noContent().build();
    }

}
