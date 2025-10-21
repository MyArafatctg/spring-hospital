package com.arafat.hospital.mappers;

import com.arafat.hospital.dtos.requestDtos.PatientRequest;
import com.arafat.hospital.dtos.responseDtos.AppointmentDoctor;
import com.arafat.hospital.dtos.responseDtos.PatientAppointment;
import com.arafat.hospital.dtos.responseDtos.PatientResponse;
import com.arafat.hospital.entities.Appointment;
import com.arafat.hospital.entities.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public PatientResponse toPatientResponse(Patient request) {
        var response = new PatientResponse();
        response.setId(request.getId());
        response.setName(request.getName());
        response.setGender(request.getGender());
        response.setMobileNumber(request.getMobileNumber());
        response.setEmail(request.getEmail());
        response.setInsurance(request.getInsurance());
        response.setAppointments(
                request.getAppointments()
                        .stream()
                        .map(appointment -> toPatientAppointment(appointment))
                        .toList());

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

    private PatientAppointment toPatientAppointment(Appointment appointment) {
        var response = new PatientAppointment();

        response.setId(appointment.getId());
        response.setReason(appointment.getReason());
        response.setDoctor(
                new AppointmentDoctor(
                        appointment.getDoctor().getId(),
                        appointment.getDoctor().getName(),
                        appointment.getDoctor().getEmail(),
                        appointment.getDoctor().getSpecialisation()
                ));
        response.setAppointmentDate(appointment.getAppointmentDate());
        return response;
    }
}
