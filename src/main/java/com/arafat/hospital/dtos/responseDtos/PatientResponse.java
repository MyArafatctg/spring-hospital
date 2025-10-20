package com.arafat.hospital.dtos.responseDtos;

import com.arafat.hospital.entities.Appointment;
import com.arafat.hospital.entities.Insurance;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PatientResponse {
    private Long id;
    private String name;
    private String gender;
    private String email;
    private String mobileNumber;
    private Insurance insurance;
    private List<PatientAppointment> appointments;
}
