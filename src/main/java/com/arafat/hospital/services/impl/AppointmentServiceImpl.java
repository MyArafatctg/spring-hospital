package com.arafat.hospital.services.impl;

import com.arafat.hospital.dtos.requestDtos.AppointmentRequest;
import com.arafat.hospital.dtos.requestDtos.PatientAppointmentRequest;
import com.arafat.hospital.dtos.responseDtos.AppointmentResponse;
import com.arafat.hospital.mappers.AppointmentMapper;
import com.arafat.hospital.repositories.AppointmentRepository;
import com.arafat.hospital.repositories.DoctorRepository;
import com.arafat.hospital.repositories.PatientRepository;
import com.arafat.hospital.services.AppointmentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper mapper;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Override
    public List<AppointmentResponse> getAppointments() {
        return appointmentRepository.findAll()
                .stream()
                .map(mapper::toAppointmentResponse)
                .toList();
    }

    @Override
    public AppointmentResponse findById(Long id) {
        return appointmentRepository.findById(id)
                .map(mapper::toAppointmentResponse).orElseThrow(
                        () -> new EntityNotFoundException("Appointment not found with id: " + id)
                );
    }

    @Override
    public AppointmentResponse create(AppointmentRequest request) {
        var appointment = mapper.toAppointment(request);
        return mapper.toAppointmentResponse(appointmentRepository.save(appointment));
    }

    @Override
    public AppointmentResponse update(AppointmentRequest request, Long id) {
        var appointment = appointmentRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Appointment not found with id: " + id)
        );

        appointment.setAppointmentDate(request.getAppointmentDate());
        appointment.setReason(request.getReason());

        return mapper.toAppointmentResponse(appointmentRepository.save(appointment));
    }

    @Override
    public void deleteById(Long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public AppointmentResponse assignAppointment(PatientAppointmentRequest request,  Long id) {
        var patient = patientRepository.findById(request.getPatientId()).orElseThrow(
                () -> new EntityNotFoundException("Patient not found with id: " + request.getPatientId())
        );

        var appointment = appointmentRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Appointment not found with id: " + id)
        );

        var doctor =  doctorRepository.findById(request.getDoctorId()).orElseThrow(
                () -> new EntityNotFoundException("Doctor not found with id: " + request.getDoctorId())
        );

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        return mapper.toAppointmentResponse(appointmentRepository.save(appointment));
    }
}
