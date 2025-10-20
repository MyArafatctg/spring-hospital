package com.arafat.hospital.mappers;

import com.arafat.hospital.dtos.requestDtos.PatientRequest;
import com.arafat.hospital.dtos.responseDtos.PatientResponse;
import com.arafat.hospital.entities.Insurance;
import com.arafat.hospital.entities.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public PatientResponse toPatientResponse(Patient request) {
        var response = new PatientResponse();
        response.setName(request.getName());
        response.setGender(request.getGender());
        response.setMobileNumber(request.getMobileNumber());
        response.setEmail(request.getEmail());
        response.setInsurance(request.getInsurance());
        response.setAppointments(request.getAppointments());

        return response;
    };

    public Patient toPatient(PatientRequest patientRequest) {
        Patient patient = new Patient();
        patient.setName(patientRequest.getName());
        patient.setGender(patientRequest.getGender());
        patient.setMobileNumber(patientRequest.getMobileNumber());
        patient.setEmail(patientRequest.getEmail());

        return patient;
    }
}
