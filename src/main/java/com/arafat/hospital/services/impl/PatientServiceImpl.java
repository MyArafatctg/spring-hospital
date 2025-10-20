package com.arafat.hospital.services.impl;

import com.arafat.hospital.dtos.requestDtos.PatientRequest;
import com.arafat.hospital.dtos.responseDtos.PatientResponse;
import com.arafat.hospital.mappers.PatientMapper;
import com.arafat.hospital.repositories.InsuranceRepository;
import com.arafat.hospital.repositories.PatientRepository;
import com.arafat.hospital.services.PatientService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper mapper;

    @Override
    public List<PatientResponse> getPatients() {
        return patientRepository.findAll()
                .stream()
                .map(mapper::toPatientResponse)
                .toList();
    }

    @Override
    public PatientResponse findById(Long id) {
        return patientRepository.findById(id).map(mapper::toPatientResponse).orElseThrow(
                () -> new EntityNotFoundException("Patient not found with id: " + id)
        );
    };

    @Override
    public PatientResponse createPatient(PatientRequest request) {
        var patient = mapper.toPatient(request);
        return mapper.toPatientResponse(patientRepository.save(patient));
    }

    @Override
    public PatientResponse updatePatient(PatientRequest request, Long id) {
        var patient = patientRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Patient not found with id: " + id)
        );

        patient.setName(request.getName());
        patient.setMobileNumber(request.getMobileNumber());
        patient.setEmail(request.getEmail());
        patient.setGender(request.getGender());

        return mapper.toPatientResponse(patientRepository.save(patient));
    }

    @Override
    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }
}
