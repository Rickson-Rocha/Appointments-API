package com.br.appointements.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.appointements.exceptions.BusinessException;
import com.br.appointements.exceptions.PatientNotFoundException;
import com.br.appointements.repositories.PatientRepository;
import com.br.appointements.schemas.Patient;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public Patient createPatient( @Valid Patient patient){
        boolean existsData = false;
        Optional<Patient> optPatient = patientRepository.findByCpfAndEmail(patient.getCpf(), patient.getEmail());
        if(optPatient.isPresent()){
            if(!optPatient.get().getId().equals(patient.getId())  || !optPatient.get().getEmail().equals(patient.getEmail())){
                existsData = true;
            }
        }
        if(existsData){
            throw new BusinessException();
        }
        return patientRepository.save(patient);
    }

    public void delete(Long id){
        patientRepository.deleteById(id);
    }


    public List<Patient> fetchAll(){
        return patientRepository.findAll();
    }

    public Patient getById(Long id){
        Optional<Patient> patient = patientRepository.findById(id);
        return patient.orElseThrow(()->new PatientNotFoundException(id));
    }


    public Patient update(Long id, Patient patientDetails) {
        // Usa o método getById para obter o paciente existente
        Patient existingPatient = getById(id);

        // Atualiza os detalhes do paciente existente com os novos dados
        existingPatient.setFirstName(patientDetails.getFirstName());
        existingPatient.setLastName(patientDetails.getLastName());
        existingPatient.setCpf(patientDetails.getCpf());
        existingPatient.setEmail(patientDetails.getEmail());

        // Salva as alterações no banco de dados
        return patientRepository.save(existingPatient);
    }

}
