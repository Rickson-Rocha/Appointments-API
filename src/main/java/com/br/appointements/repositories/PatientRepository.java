package com.br.appointements.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.appointements.schemas.Patient;

public interface PatientRepository  extends JpaRepository <Patient , Long>{
    Optional<Patient> findByCpfAndEmail(String cpf,String email);
    
}
