package com.arafat.hospital.services;

import com.arafat.hospital.dtos.requestDtos.PatientAppointmentRequest;
import com.arafat.hospital.dtos.requestDtos.PatientInsuranceRequest;
import com.arafat.hospital.dtos.requestDtos.PatientRequest;
import com.arafat.hospital.dtos.responseDtos.PatientResponse;

import java.util.List;

public interface PatientService {
    List<PatientResponse> getPatients();
    PatientResponse findById(Long id);
    PatientResponse createPatient(PatientRequest request);
    PatientResponse updatePatient(PatientRequest request, Long id);
    void deleteById(Long id);

    PatientResponse addInsurance(PatientInsuranceRequest request);
}
