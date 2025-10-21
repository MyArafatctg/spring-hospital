package com.arafat.hospital.services.impl;

import com.arafat.hospital.dtos.requestDtos.PatientAppointmentUpdate;
import com.arafat.hospital.dtos.requestDtos.PatientInsuranceRequest;
import com.arafat.hospital.dtos.requestDtos.PatientRequest;
import com.arafat.hospital.dtos.responseDtos.PatientAppointment;
import com.arafat.hospital.dtos.responseDtos.PatientResponse;
import com.arafat.hospital.mappers.PatientMapper;
import com.arafat.hospital.repositories.AppointmentRepository;
import com.arafat.hospital.repositories.DoctorRepository;
import com.arafat.hospital.repositories.InsuranceRepository;
import com.arafat.hospital.repositories.PatientRepository;
import com.arafat.hospital.services.DoctorServices;
import com.arafat.hospital.services.InsuranceService;
import com.arafat.hospital.services.PatientService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final InsuranceRepository insuranceRepository;
    private final AppointmentRepository appointmentRepository;

    private final PatientMapper mapper;
    private final InsuranceService insuranceService;
    private final DoctorServices doctorServices;
    private final DoctorRepository doctorRepository;

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

    @Override
    public PatientResponse addInsurance(PatientInsuranceRequest request) {
        var patient = patientRepository.findById(request.getPatientId()).orElseThrow(
                () -> new EntityNotFoundException("Patient not found with id: " + request.getPatientId())
        );

        var insurance = insuranceRepository.findById(request.getInsuranceId()).orElseThrow(
                () -> new EntityNotFoundException("Insurance not found with id: " + request.getInsuranceId())
        );

        patient.setInsurance(insurance);
        return mapper.toPatientResponse(patientRepository.save(patient));
    }

    @Override
    public PatientResponse removeInsurance(PatientInsuranceRequest request) {
        var patient = patientRepository.findById(request.getPatientId()).orElseThrow(
                () -> new EntityNotFoundException("Patient not found with id: " + request.getPatientId())
        );

        if (!Objects.equals(patient.getInsurance().getId(), request.getInsuranceId())) {
            throw new EntityNotFoundException("Insurance not found with id: " + request.getInsuranceId());
        };

        patient.setInsurance(null);
        patientRepository.save(patient);
        insuranceService.deleteById(request.getInsuranceId());

        return mapper.toPatientResponse(patient);
    }

    @Override
    public PatientResponse updateAppointment(PatientAppointmentUpdate request, Long patientId, Long appointmentId) {
        var  patient = patientRepository.findById(patientId).orElseThrow(
                () -> new EntityNotFoundException("Patient not found with id: " + patientId)
        );

        var patientAppointment = patient.getAppointments()
                .stream()
                .filter(appointment -> appointmentId.equals(appointment.getId()))
                .findFirst()
                .orElseThrow(
                        () -> new EntityNotFoundException("Appointment not found with id: " + appointmentId)
                );


        patientAppointment.setReason(request.getReason());
        patientAppointment.setAppointmentDate(request.getAppointmentDate());

        return mapper.toPatientResponse(patientRepository.save(patient));
    }

}
