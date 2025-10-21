package com.arafat.hospital.mappers;

import com.arafat.hospital.dtos.requestDtos.AppointmentRequest;
import com.arafat.hospital.dtos.responseDtos.AppointmentDoctor;
import com.arafat.hospital.dtos.responseDtos.AppointentPatient;
import com.arafat.hospital.dtos.responseDtos.AppointmentResponse;
import com.arafat.hospital.entities.Appointment;
import com.arafat.hospital.entities.Doctor;
import com.arafat.hospital.entities.Patient;
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
        appointmentResponse.setPatient(appointment.getPatient() != null ? toPatient(appointment.getPatient()) : null);
        appointmentResponse.setDoctor(appointment.getDoctor() != null ? toDoctor(appointment.getDoctor()) : null);

        return appointmentResponse;

    }

    private AppointentPatient toPatient(Patient  patient) {
        AppointentPatient appointentPatient = new AppointentPatient();

        appointentPatient.setId(patient.getId());
        appointentPatient.setName(patient.getName());
        appointentPatient.setGender(patient.getGender());
        appointentPatient.setEmail(patient.getEmail());
        appointentPatient.setMobileNumber(patient.getMobileNumber());

        return appointentPatient;
    }

    private AppointmentDoctor toDoctor(Doctor doctor) {
        AppointmentDoctor appointmentDoctor = new AppointmentDoctor();

        appointmentDoctor.setId(doctor.getId());
        appointmentDoctor.setName(doctor.getName());
        appointmentDoctor.setEmail(doctor.getEmail());
        appointmentDoctor.setSpecialisation(appointmentDoctor.getSpecialisation());

        return appointmentDoctor;
    }
}
