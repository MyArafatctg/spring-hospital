package com.arafat.hospital.mappers;

import com.arafat.hospital.dtos.requestDtos.AppointmentRequest;
import com.arafat.hospital.dtos.responseDtos.AppointentDoctor;
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
        appointmentResponse.setPatient(toPatient(appointment.getPatient()));
        appointmentResponse.setDoctor(toDoctor(appointment.getDoctor()));

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

    private AppointentDoctor toDoctor(Doctor doctor) {
        AppointentDoctor appointentDoctor = new AppointentDoctor();

        appointentDoctor.setId(doctor.getId());
        appointentDoctor.setName(doctor.getName());
        appointentDoctor.setEmail(doctor.getEmail());
        appointentDoctor.setSpecialisation(appointentDoctor.getSpecialisation());

        return appointentDoctor;
    }
}
