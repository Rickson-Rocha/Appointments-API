package com.br.appointements.exceptions;

import com.br.appointements.schemas.Patient;

public class PatientNotFoundException extends RuntimeException {
    private final Long id; 

    public PatientNotFoundException(Long id) {
        super("Patient(s) not found with id: " + id + " of type " + Patient.class.getName());
        this.id = id; 
    }

    public PatientNotFoundException(String message) {
        super(message);
        this.id = null; 
    }

    public Long getId() {
        return id; 
    }
}
