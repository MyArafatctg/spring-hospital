package com.arafat.hospital.services;

import com.arafat.hospital.dtos.requestDtos.AppointmentRequest;
import com.arafat.hospital.dtos.requestDtos.PatientAppointmentRequest;
import com.arafat.hospital.dtos.responseDtos.AppointmentResponse;
import com.arafat.hospital.dtos.responseDtos.PatientResponse;

import java.util.List;

public interface AppointmentService {
    List<AppointmentResponse> getAppointments();
    AppointmentResponse findById(Long id);
    AppointmentResponse create(AppointmentRequest request);
    AppointmentResponse update(AppointmentRequest request, Long id);
    void deleteById(Long id);

    AppointmentResponse assignAppointment(PatientAppointmentRequest request, Long id);
}
