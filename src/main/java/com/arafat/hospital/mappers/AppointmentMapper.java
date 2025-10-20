package com.arafat.hospital.mappers;

import com.arafat.hospital.dtos.requestDtos.AppointmentRequest;
import com.arafat.hospital.dtos.responseDtos.AppointmentResponse;
import com.arafat.hospital.entities.Appointment;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {
    public Appointment toAppointment(AppointmentRequest appointmentRequest) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentDate(appointmentRequest.getAppointmentDate());
        appointment.setReason(appointmentRequest.getReason());
        return appointment;
    };

    public AppointmentResponse toAppointmentResponse(Appointment appointment) {
        AppointmentResponse appointmentResponse = new AppointmentResponse();
        appointmentResponse.setId(appointment.getId());
        appointmentResponse.setAppointmentDate(appointment.getAppointmentDate());
        appointmentResponse.setReason(appointment.getReason());
        appointmentResponse.setPatient(appointment.getPatient());
        appointmentResponse.setDoctor(appointment.getDoctor());

        return appointmentResponse;

    }
}
