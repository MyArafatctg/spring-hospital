package com.arafat.hospital.services;

import com.arafat.hospital.dtos.requestDtos.AppointmentRequest;
import com.arafat.hospital.dtos.requestDtos.DoctorRequest;
import com.arafat.hospital.dtos.responseDtos.AppointmentResponse;
import com.arafat.hospital.dtos.responseDtos.DoctorResponse;

import java.util.List;

public interface DoctorServices {
    List<DoctorResponse> getAll();
    DoctorResponse findById(Long id);
    DoctorResponse create(DoctorRequest request);
    DoctorResponse update(DoctorRequest request, Long id);
    void deleteById(Long id);
}
