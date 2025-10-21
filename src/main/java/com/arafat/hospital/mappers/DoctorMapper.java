package com.arafat.hospital.mappers;

import com.arafat.hospital.dtos.requestDtos.DoctorRequest;
import com.arafat.hospital.dtos.responseDtos.AppointmentDoctor;
import com.arafat.hospital.dtos.responseDtos.DoctorResponse;
import com.arafat.hospital.dtos.responseDtos.PatientAppointment;
import com.arafat.hospital.entities.Appointment;
import com.arafat.hospital.entities.Doctor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@Getter
@Setter
@AllArgsConstructor
public class DoctorMapper {
    private final DepartmentMapper departmentMapper;

    public DoctorResponse toDoctorResponse(Doctor doctor) {

        DoctorResponse response = new DoctorResponse();
        response.setId(doctor.getId());
        response.setName(doctor.getName());
        response.setEmail(doctor.getEmail());
        response.setSpecialisation(doctor.getSpecialisation());
        response.setAppointment(
                doctor.getAppointment() != null ?
                doctor.getAppointment()
                .stream()
                .map(this::toPatientAppointment)
                .toList() : null);
        response.setDepartments(doctor.getDepartments()
                .stream()
                .map(departmentMapper::toDepartmentResponse)
                .collect(Collectors.toSet()));

        return response;
    }

    public Doctor toDoctor(DoctorRequest request) {
        Doctor doctor = new Doctor();

        doctor.setName(request.getName());
        doctor.setEmail(request.getEmail());
        doctor.setSpecialisation(request.getSpecialisation());

        return doctor;
    }

    private PatientAppointment toPatientAppointment(Appointment appointment) {
        PatientAppointment patientAppointment = new PatientAppointment();

        patientAppointment.setId(appointment.getId());
        patientAppointment.setAppointmentDate(appointment.getAppointmentDate());
        patientAppointment.setReason(appointment.getReason());
        patientAppointment.setDoctor(
                appointment.getDoctor() != null ?
                new AppointmentDoctor(
                        appointment.getDoctor().getId(),
                        appointment.getDoctor().getName(),
                        appointment.getDoctor().getSpecialisation(),
                        appointment.getDoctor().getEmail()
                ) : null
        );

        return patientAppointment;
    }
}
