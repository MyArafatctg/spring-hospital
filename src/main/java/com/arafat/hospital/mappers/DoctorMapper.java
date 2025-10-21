package com.arafat.hospital.mappers;

import com.arafat.hospital.dtos.requestDtos.DoctorRequest;
import com.arafat.hospital.dtos.responseDtos.AppointmentDoctor;
import com.arafat.hospital.dtos.responseDtos.DoctorResponse;
import com.arafat.hospital.dtos.responseDtos.PatientAppointment;
import com.arafat.hospital.entities.Appointment;
import com.arafat.hospital.entities.Doctor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class DoctorMapper {
    public DoctorResponse toDoctorResponse(Doctor doctor) {

        DoctorResponse response = new DoctorResponse();
        response.setId(doctor.getId());
        response.setName(doctor.getName());
        response.setEmail(doctor.getEmail());
        response.setSpecialisation(doctor.getSpecialisation());
        response.setAppointment(doctor.getAppointment());
        response.setDepartments(doctor.getDepartments());

        return response;
    }

    public Doctor toDoctor(DoctorRequest request) {
        Doctor doctor = new Doctor();

        doctor.setName(request.getName());
        doctor.setEmail(request.getEmail());
        doctor.setSpecialisation(request.getSpecialisation());

        return doctor;
    }

//    private PatientAppointment toPatientAppointment(Appointment appointment) {
//        PatientAppointment patientAppointment = new PatientAppointment();
//
//        patientAppointment.setId(appointment.getId());
//        patientAppointment.setAppointmentDate(appointment.getAppointmentDate());
//        patientAppointment.set
//    }
}
